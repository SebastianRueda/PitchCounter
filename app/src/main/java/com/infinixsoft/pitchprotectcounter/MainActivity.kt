package com.infinixsoft.pitchprotectcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var maxProgressBar = 10
    var progressBar: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar1.max = maxProgressBar
        progressBar2.max = maxProgressBar
        progressBar3.max = maxProgressBar
        progressBar4.max = maxProgressBar
        progressBar5.max = maxProgressBar

        res.setOnClickListener {
            setSubProgressBar(progressBar)
        }
        sum.setOnClickListener {
            setSumProgressBar(progressBar)
        }
    }

    private fun setSubProgressBar(progress: Int) {
        when {
            progress == 0 -> {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
                progressBar1.progress = progressBar1.progress.dec()
                return
            }
            progress < maxProgressBar -> {
                progressBar1.progress = progressBar1.progress.dec()
            }
            progress <= maxProgressBar * 2 -> {
                progressBar3.progress = 0
                progressBar2.progress = progressBar2.progress.dec()
            }
            progress <= maxProgressBar * 3 -> {
                progressBar4.progress = 0
                progressBar3.progress = progressBar3.progress.dec()
            }
            progress <= maxProgressBar * 4 -> {
                progressBar5.progress = 0
                progressBar4.progress = progressBar4.progress.dec()
            }
            progress <= maxProgressBar * 5 -> {
                progressBar5.progress = progressBar5.progress.dec()
            }
        }

        progressBar = progressBar.dec()
        Toast.makeText(this, "$progressBar", Toast.LENGTH_SHORT).show()
    }

    private fun setSumProgressBar(progress: Int) {
        when {
            /*progressBar1.progress < maxProgressBar -> {
                progressBar1.progress = progress
                return
            }
            progressBar2.progress < progress % maxProgressBar -> {
                progressBar2.progress = progress % maxProgressBar
                return
            }
            progress.toDouble() / maxProgressBar.toDouble() == 2.0 -> {
                progressBar2.progress = maxProgressBar
                return
            }
            progressBar3.progress < progress % maxProgressBar -> {
                progressBar3.progress = progress % maxProgressBar
                return
            }
            progress.toDouble() / maxProgressBar.toDouble() == 3.0 -> {
                progressBar3.progress = maxProgressBar
                return
            }
            progressBar4.progress < progress % maxProgressBar -> {
                progressBar4.progress = progress % maxProgressBar
                return
            }
            progress.toDouble() / maxProgressBar.toDouble() == 4.0 -> {
                progressBar4.progress = maxProgressBar
                return
            }
            progressBar5.progress < progress % maxProgressBar -> {
                progressBar5.progress = progress % maxProgressBar
                return
            }
            progress.toDouble() / maxProgressBar.toDouble() == 5.0 -> {
                progressBar5.progress = maxProgressBar
                return
            }*/

            progress <= maxProgressBar -> {
                progressBar1.progress = progressBar1.progress.inc()
            }
            progress <= maxProgressBar * 2 -> {
                progressBar2.progress = progressBar2.progress.inc()
            }
            progress <= maxProgressBar * 3 -> {
                progressBar3.progress = progressBar3.progress.inc()
            }
            progress <= maxProgressBar * 4 -> {
                progressBar4.progress = progressBar4.progress.inc()
            }
            progress <= maxProgressBar * 5 -> {
                progressBar5.progress = progressBar5.progress.inc()
            }

            maxProgressBar < progress -> {
                Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show()
                return
            }
        }

        progressBar = progressBar.inc()
        Toast.makeText(this, "$progressBar", Toast.LENGTH_SHORT).show()
    }
}
