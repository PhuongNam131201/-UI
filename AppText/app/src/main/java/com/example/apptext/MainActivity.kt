package com.example.apptext

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apptext.Login
import android.view.GestureDetector
import android.view.MotionEvent
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Xử lý ImageView
        val imageView = findViewById<ImageView>(R.id.imageView2) // ID của nút "Vào"
        imageView.setOnClickListener {
            try {
                val intent = Intent(this, Login ::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Lỗi: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }


        // Xử lý Button
        val myButton = findViewById<Button>(R.id.button2) // Đảm bảo ID đúng
        myButton.setOnClickListener {
            // Xử lý khi button được nhấn
            Toast.makeText(this, "Button đã được nhấn!", Toast.LENGTH_SHORT).show()
        }

    }

}
