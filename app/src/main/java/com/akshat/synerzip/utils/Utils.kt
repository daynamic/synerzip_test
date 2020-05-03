package com.akshat.synerzip.utils

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.akshat.synerzip.R

/**
 * Created by Akshat on 2020-05-01.
 */

/**
 * Extension for displaying toast which will take string as a parameter.
 * */

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * Extension for displaying an Alert Dialog which will take string as a parameter.
 * */
fun Context.alertDialog(message: String) {
    val dialogBuilder = AlertDialog.Builder(this, R.style.MyAlertDialogTheme)
    dialogBuilder.setMessage(message)
        .setCancelable(false)
        .setPositiveButton("OK") { dialog, which ->

        }

    val alert = dialogBuilder.create()
    alert.show()
}

/**
 * Extension for displaying Progress dialog which will take string as a parameter.
 * */
var barProgressDialog: ProgressDialog? = null

fun Context.showprogressDialog(
    context: Context,
    message: String,
    title: String,
    cancelable: Boolean
) {

    barProgressDialog = ProgressDialog(context, R.style.MyAlertDialogTheme)
    barProgressDialog?.setMessage(message)
    barProgressDialog?.setCancelable(cancelable)
    barProgressDialog?.show()

}

/**
 * Extension for stopping Progress dialog which will take string as a parameter.
 * */

fun Context.dismissprogressDialog(context: Context) {
    if (barProgressDialog != null) {
        barProgressDialog?.cancel()
    }
}