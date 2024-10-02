package com.example.apptext

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Kích hoạt chế độ hiển thị toàn màn hình

        setContentView(R.layout.activity_signup) // Thiết lập layout cho Activity

        // Thiết lập padding cho view chính để tránh bị che khuất bởi thanh trạng thái và thanh điều hướng
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Lấy TextView để xử lý sự kiện click
        val textView = findViewById<TextView>(R.id.textView8) // ID của nút "Vào"
        textView.setOnClickListener {
            try {
                // Khởi tạo Intent để chuyển đến Login Activity
                val intent = Intent(this, Login::class.java)
                startActivity(intent) // Bắt đầu Activity mới
            } catch (e: Exception) {
                // Hiển thị thông báo lỗi nếu có
                Toast.makeText(this, "Lỗi: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
        val imageView = findViewById<ImageView>(R.id.imageView3)
        imageView.setOnLongClickListener {
            // Thực hiện hành động khi imageView3 được nhấn lâu
            val intent = Intent(this, MainActivity ::class.java)
            startActivity(intent)
            // Trả về true để chỉ ra rằng sự kiện đã được xử lý
            true
        }
        // Lấy EditText để xử lý sự kiện thay đổi văn bản
        val emailInput = findViewById<EditText>(R.id.editTextText5)

        // Thêm TextWatcher để theo dõi sự thay đổi văn bản trong EditText
        emailInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Xử lý trước khi văn bản thay đổi (nếu cần)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Xử lý khi văn bản đang thay đổi (nếu cần)
            }

            override fun afterTextChanged(s: Editable?) {
                // Xử lý sau khi văn bản đã thay đổi
                validateEmail(s.toString()) // Gọi hàm validateEmail để kiểm tra tính hợp lệ của email
            }
        })
    }

    // Hàm để kiểm tra tính hợp lệ của email
    private fun validateEmail(email: String) {
        // Kiểm tra định dạng email (có thể sử dụng regex hoặc phương thức khác)
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // Nếu email không hợp lệ, hiển thị thông báo
            Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_SHORT).show()
        }
    }

}
