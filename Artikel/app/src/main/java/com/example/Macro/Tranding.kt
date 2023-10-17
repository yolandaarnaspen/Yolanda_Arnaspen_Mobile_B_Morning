import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.Macro.Artikel1
import com.example.artikel.R

class Tranding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tranding)

        val artikel1Layout: LinearLayout = findViewById(R.id.linearLayoutArtikel13)
        val artikel2Layout: LinearLayout = findViewById(R.id.linearLayoutArtikel14)
        val artikel3Layout: LinearLayout = findViewById(R.id.linearLayoutArtikel15)

        artikel1Layout.setOnClickListener {
            val intent = Intent(this@Tranding, Artikel1::class.java)
            startActivity(intent)
        }


    }
}
