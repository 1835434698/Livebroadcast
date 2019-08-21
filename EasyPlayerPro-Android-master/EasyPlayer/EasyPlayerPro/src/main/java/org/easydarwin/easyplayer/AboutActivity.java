package org.easydarwin.easyplayer;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;

import org.esaydarwin.rtsp.player.BuildConfig;
import org.esaydarwin.rtsp.player.R;
import org.esaydarwin.rtsp.player.databinding.ActivityAboutBinding;

public class AboutActivity extends AppCompatActivity {

    private ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about);

        setSupportActionBar(binding.toolbar);
        binding.title.setText("EasyPlayer Pro全功能播放器：");
        binding.desc.setText("EasyPlayer Pro专业版全功能播放器，是由EasyDarwin开源团队维护的一款支持RTSP、RTMP、HTTP、HLS多种流媒体协议的播放器版本，更多详情邮件咨询：");
        binding.desc.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString spannableString = new SpannableString("support@easydarwin.org");
        //设置下划线文字
        spannableString.setSpan(new URLSpan("mailto:support@easydarwin.org"), 0, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        //设置文字的前景色
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        binding.desc.append(spannableString);

        binding.desc.append("\n您也可以使用EasyPlayer RTSP版本，更轻，更精炼！EasyPlayer RTSP版本");
        spannableString = new SpannableString("戳我");
        //设置下划线文字
        spannableString.setSpan(new URLSpan("https://fir.im/EasyPlayer"), 0, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        //设置文字的前景色
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        binding.desc.append(spannableString);
        binding.desc.append("或者扫描下载:");
        binding.imageView.setImageResource(R.drawable.qrcode);

        binding.textView4.setText(BuildConfig.VERSION_CODE + "  " +BuildConfig.VERSION_NAME);
    }
}
