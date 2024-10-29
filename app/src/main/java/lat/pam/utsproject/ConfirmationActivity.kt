package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val namaMakanan = intent.getStringExtra("NAMA_MAKANAN")
        val servings = intent.getStringExtra("SERVINGS")
        val orderingName = intent.getStringExtra("ORDERING_NAME")
        val notes = intent.getStringExtra("NOTES")

        // Tampilkan data di TextView
        findViewById<TextView>(R.id.tvFoodName).text = "Food Name: $namaMakanan"
        findViewById<TextView>(R.id.tvServings).text = "Number of Servings: $servings pcs"
        findViewById<TextView>(R.id.tvOrderingName).text = "Ordering Name: $orderingName"
        findViewById<TextView>(R.id.tvNotes).text = "Additional Notes: $notes"

        // Set OnClickListener untuk tombol backtoMenu
        findViewById<Button>(R.id.backtoMenu).setOnClickListener {
            // Intent untuk kembali ke ListFoodActivity
            val intent = Intent(this, ListFoodActivity::class.java)
            // Mengosongkan activity stack agar tidak ada tumpukan activity sebelumnya
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish() // Menutup ConfirmationActivity
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}