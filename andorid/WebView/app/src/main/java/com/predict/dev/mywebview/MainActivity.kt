package com.predict.dev.mywebview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

private const val TAG = "MainActivity::"

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        button.setOnClickListener {
            Log.d(TAG, "test : ");
            Toast.makeText(getBaseContext(), "모드를 선택하세요.", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                savePreferences(1);
                loadDeviceManger()
                Log.d("predict::", "deivce")
            }
            R.id.nav_gallery -> {
                savePreferences(2);
                loadDeviceManger()
                Log.d("predict::", "webView deivce")
            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {
                var myWebView = findViewById(R.id.webview) as WebView
                myWebView.post { myWebView.loadUrl("javascript:_interface_js_native._init('0.001')") }
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    // 값 저장하기
    private fun savePreferences(mode: Int){
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("key1", "value")
        editor.putInt("key2", mode)
        editor.commit()
    }

    // 디바이스 관리자 로드
    private fun loadDeviceManger() {

        val intent = Intent(this, SelectDeviceActivity::class.java)

        startActivity(intent)

    }

}
