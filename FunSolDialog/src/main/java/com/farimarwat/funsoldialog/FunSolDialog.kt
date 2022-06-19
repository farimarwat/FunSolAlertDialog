package com.farimarwat.funsoldialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView

class FunSolDialog private constructor(builder:Builder){
    var title:String? = null
    var message:String? = null
    var positive:String? = null
    var negative:String? = null
    var dialogtype = 1
    var cancelable:Boolean = false
    companion object{
        val TYPE_INFO = 1
        val TYPE_SUCCESS = 2
        val TYPE_ERROR = 3
    }
    var mListener:FunSolDialogButtonClickListener?=null
    lateinit var mAlertDialog:AlertDialog
    var mContext: Context
    class Builder(val context: Context){
        private var title:String? = null
        private var message:String? = null
        private var positive:String? = null
        private var negative:String? = null
        private var dialogtype = 1
        private var cancelable:Boolean = false
        var mListener:FunSolDialogButtonClickListener?=null

        fun setTitle(title:String?) = apply { this.title = title }
        fun setMessage(message:String?) = apply { this.message = message }
        fun setDialogType(type:Int) = apply { this.dialogtype = type }
        fun setCancelable(cancelable:Boolean) = apply { this.cancelable = cancelable }
        fun setPositive(positive:String?,listener: FunSolDialogButtonClickListener?)=
            apply {
                this.positive = positive
                this.mListener = listener
            }
        fun setNegative(negative:String?,listener: FunSolDialogButtonClickListener?)=
            apply {
                this.negative = negative
                this.mListener = listener
            }

        fun getTitle() = this.title
        fun getMessage() = this.message
        fun getDialogType() = this.dialogtype
        fun getPositive() = this.positive
        fun getNegative() = this.negative
        fun getCancelable() =this.cancelable

        fun build() = FunSolDialog(this)
    }
    init {
        mContext = builder.context
        this.title = builder.getTitle()
        this.message  = builder.getMessage()
        this.positive = builder.getPositive()
        this.negative = builder.getNegative()
        this.mListener = builder.mListener
        this.dialogtype = builder.getDialogType()
        this.cancelable = builder.getCancelable()
    }
    fun show(){
        val view = LayoutInflater.from(mContext)
            .inflate(R.layout.item_dialog,null)
        val txt_title = view.findViewById<TextView>(R.id.txt_title)
        val txt_message = view.findViewById<TextView>(R.id.txt_message)
        txt_title.text = this.title
        txt_message.text = this.message

        //setting buttons
        val txt_positive = view.findViewById<TextView>(R.id.btn_positive)
        if(positive != null){
            txt_positive.visibility = View.VISIBLE
            txt_positive.setOnClickListener{
                mListener?.onButtonClicked(mAlertDialog)
            }
        } else {
            txt_positive.visibility = View.GONE
        }
        val txt_negative = view.findViewById<TextView>(R.id.btn_negative)
        if(negative != null){
            txt_negative.visibility = View.VISIBLE
            txt_negative.setOnClickListener{
                mListener?.onButtonClicked(mAlertDialog)
            }
        }else {
            txt_negative.visibility = View.GONE
        }
        //End setting buttons

        val img_close = view.findViewById<ImageView>(R.id.img_close)
        img_close.setOnClickListener{
            mAlertDialog.dismiss()
        }
        //end setting view

        //setting type
        when(dialogtype){
            TYPE_ERROR -> error(view)
            TYPE_INFO -> info(view)
            TYPE_SUCCESS -> success(view)
        }
        //end setting type

        val builder = AlertDialog.Builder(mContext)
            .setView(view)
        mAlertDialog = builder.create()
        mAlertDialog.setCancelable(cancelable)
        mAlertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        mAlertDialog.show()
    }
    fun error(view:View){
        val txt_title = view.findViewById<TextView>(R.id.txt_title)
        val txt_message = view.findViewById<TextView>(R.id.txt_message)
        val container = view.findViewById<RelativeLayout>(R.id.container)
        container.background = ContextCompat.getDrawable(mContext,R.drawable.bg_error)
        val icon = view.findViewById<LottieAnimationView>(R.id.lottie_icon)
        val container_title = view.findViewById<RelativeLayout>(R.id.container_title)
        val btn_negative = view.findViewById<TextView>(R.id.btn_negative)
        val btn_positive = view.findViewById<TextView>(R.id.btn_positive)

        txt_message.setTextColor(ContextCompat.getColor(mContext,R.color.errorPrimary))
        icon.setAnimation(R.raw.error)
        container_title.background  = ContextCompat.getDrawable(mContext,R.drawable.bg_error_title)
        btn_negative.background = ContextCompat.getDrawable(mContext,R.drawable.bg_error_btn_negative)
        btn_negative.setTextColor(ContextCompat.getColor(mContext,R.color.errorPrimary))
        btn_positive.background = ContextCompat.getDrawable(mContext,R.drawable.bg_error_btn_positive)

    }
    fun success(view:View){
        val txt_title = view.findViewById<TextView>(R.id.txt_title)
        val txt_message = view.findViewById<TextView>(R.id.txt_message)
        val container = view.findViewById<RelativeLayout>(R.id.container)
        container.background = ContextCompat.getDrawable(mContext,R.drawable.bg_success)
        val icon = view.findViewById<LottieAnimationView>(R.id.lottie_icon)
        val container_title = view.findViewById<RelativeLayout>(R.id.container_title)
        val btn_negative = view.findViewById<TextView>(R.id.btn_negative)
        val btn_positive = view.findViewById<TextView>(R.id.btn_positive)

        txt_message.setTextColor(ContextCompat.getColor(mContext,R.color.successPrimary))
        icon.setAnimation(R.raw.success)
        container_title.background  = ContextCompat.getDrawable(mContext,R.drawable.bg_success_title)
        btn_negative.background = ContextCompat.getDrawable(mContext,R.drawable.bg_success_btn_negative)
        btn_negative.setTextColor(ContextCompat.getColor(mContext,R.color.successPrimary))
        btn_positive.background = ContextCompat.getDrawable(mContext,R.drawable.bg_success_btn_positive)
    }
    fun info(view:View){
        val txt_title = view.findViewById<TextView>(R.id.txt_title)
        val txt_message = view.findViewById<TextView>(R.id.txt_message)
        val container = view.findViewById<RelativeLayout>(R.id.container)
        container.background = ContextCompat.getDrawable(mContext,R.drawable.bg_info)
        val icon = view.findViewById<LottieAnimationView>(R.id.lottie_icon)
        val container_title = view.findViewById<RelativeLayout>(R.id.container_title)
        val btn_negative = view.findViewById<TextView>(R.id.btn_negative)
        val btn_positive = view.findViewById<TextView>(R.id.btn_positive)

        txt_message.setTextColor(ContextCompat.getColor(mContext,R.color.infoPrimary))
        icon.setAnimation(R.raw.info)
        container_title.background  = ContextCompat.getDrawable(mContext,R.drawable.bg_info_title)
        btn_negative.background = ContextCompat.getDrawable(mContext,R.drawable.bg_info_btn_negative)
        btn_negative.setTextColor(ContextCompat.getColor(mContext,R.color.infoPrimary))
        btn_positive.background = ContextCompat.getDrawable(mContext,R.drawable.bg_info_btn_positive)
    }
    fun hide(){
        if(this@FunSolDialog::mAlertDialog.isInitialized){
            mAlertDialog.dismiss()
        }
    }

    interface FunSolDialogButtonClickListener{
        fun onButtonClicked(dialog:AlertDialog)
    }
}