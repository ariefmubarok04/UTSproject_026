package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val namaMakanan = intent.getStringExtra("NAMA_MAKANAN")
        val etFoodName = findViewById<TextView>(R.id.etFoodName)
        etFoodName.text = namaMakanan

        val textOrder = findViewById<TextView>(R.id.etFoodName)
        textOrder.text = "$namaMakanan"

        val etServings = findViewById<EditText>(R.id.etServings)
        val etName = findViewById<EditText>(R.id.etName)
        val etNotes = findViewById<EditText>(R.id.etNotes)
        val btnOrder = findViewById<Button>(R.id.btnOrder)

        // Listener untuk tombol Place Order
        btnOrder.setOnClickListener {
            val servings = etServings.text.toString()
            val name = etName.text.toString()
            val notes = etNotes.text.toString()

            // Membuat Intent ke ConfirmationActivity
            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("NAMA_MAKANAN", namaMakanan)
                putExtra("SERVINGS", servings)
                putExtra("ORDERING_NAME", name)
                putExtra("NOTES", notes)
            }
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}