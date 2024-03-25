package com.smallmarker.leetcode_kotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.smallmarker.leetcode_kotlin.questions._0002.Solution
import com.smallmarker.leetcode_kotlin.ui.theme.LeetCodeKotlinTheme
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeetCodeKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        val n = Solution().addTwoNumbers(Solution.ListNode(2).apply {
            this.next = Solution.ListNode(4).apply {
                this.next = Solution.ListNode(3)
            }
        }, Solution.ListNode(5).apply {
            this.next = Solution.ListNode(6).apply {
                this.next = Solution.ListNode(4)
            }
        })
        Log.d("TAG","================" + n)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LeetCodeKotlinTheme {
        Greeting("Android")
    }
}
