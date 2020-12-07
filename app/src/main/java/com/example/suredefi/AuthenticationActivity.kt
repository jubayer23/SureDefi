package com.example.suredefi


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.amazonaws.mobile.client.*


class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        AWSMobileClient.getInstance()
            .initialize(applicationContext, object : Callback<UserStateDetails?> {


                override fun onError(e: Exception?) {
                    Log.e("INIT", "Initialization error.", e)
                }

                override fun onResult(result: UserStateDetails?) {
                    Log.i("INIT", "onResult: " + result?.userState)
                    when (result?.userState) {
                        UserState.SIGNED_IN -> {
                            gotoHome()
                            //finish()
                        }
                        UserState.SIGNED_OUT -> showSignIn()
                        else -> { // Note the block
                            AWSMobileClient.getInstance().signOut();
                            showSignIn()
                        }
                    }
                }
            }
            )
    }


    private fun gotoHome(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun showSignIn(){
        try {
            AWSMobileClient.getInstance().showSignIn(
                this,
                SignInUIOptions.builder().nextActivity(HomeActivity::class.java).logo(R.mipmap.ic_launcher).canCancel(false).build()
            )
        } catch (e: java.lang.Exception) {
            Log.e("DEBUG", e.toString())
        }
    }

}




