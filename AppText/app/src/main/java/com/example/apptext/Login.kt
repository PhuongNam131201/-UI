package com.example.apptext

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.net.Uri
class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        registerForContextMenu(findViewById(R.id.imageView6))
        val textView = findViewById<TextView>(R.id.textView8) // ID của nút "Vào"
        textView.setOnClickListener {
            try {
                val intent = Intent(this, SignUp ::class.java)
                startActivity(intent)
            } catch (e: Exception) {
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

    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Chọn hành động")
        menu?.add(0, v?.id ?: 0, 0, "Mở facebook")
        menu?.add(0, v?.id ?: 0, 1, "Hành động 2")
        menu?.add(0, v?.id ?: 0, 2, "Hành động 3")
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // Kiểm tra ID của mục được chọn
            R.id.imageView6 -> {
                when (item.title) {
                    "Mở facebook" -> {
                        openFacebook()
                        true
                    }
                    "Hành động 2" -> {
                        Toast.makeText(this, "Bạn đã chọn hành động 2", Toast.LENGTH_SHORT).show()
                        true
                    }
                    "Hành động 3" -> {
                        Toast.makeText(this, "Bạn đã chọn hành động 3", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> super.onContextItemSelected(item)
                }
            }
            else -> super.onContextItemSelected(item)
        }
    }
    private fun openFacebook() {
        // Kiểm tra xem Facebook có được cài đặt không
        try {
            val intent = packageManager.getPackageInfo("com.facebook.katana", 0)
            val facebookIntent = Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com"))
            startActivity(facebookIntent)
        } catch (e: Exception) {
            // Nếu không có, mở trình duyệt
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"))
            startActivity(browserIntent)
        }
    }


}
