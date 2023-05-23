package com.example.latifah22

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class userActivity : AppCompatActivity() {
    private lateinit var logoutBtn: Button
    private lateinit var nama_lengkap: TextView
    private lateinit var sessionManager: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        sessionManager = Session(this)

        logoutBtn = findViewById(R.id.btnlogout)
        nama_lengkap = findViewById(R.id.textNama)

        if (!sessionManager.isloggedIn()) {
            intent = Intent(this,  MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            nama_lengkap.text = sessionManager.getUser()
        }

        logoutBtn.setOnClickListener {
            val session = sessionManager.logout()
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}