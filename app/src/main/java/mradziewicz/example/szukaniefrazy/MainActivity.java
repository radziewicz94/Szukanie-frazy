package mradziewicz.example.szukaniefrazy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button clipboardButton;
    private TextView textView;
    private Button resetBtn;
    private Button findBtn;
    private EditText showEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showEditText = (EditText)findViewById(R.id.showEditText);
        showEditText.setVisibility(View.INVISIBLE);
        clipboardButton = (Button)findViewById(R.id.copyText);
        textView = (TextView)findViewById(R.id.textView);
        clipboardButton.setOnClickListener(view -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            textView.setText(clipboard.getText().toString());
        });
        resetBtn = (Button)findViewById(R.id.reset);
        resetBtn.setOnClickListener(view -> {
            textView.setText("");
        });

        findBtn = (Button)findViewById(R.id.findPhase);
        findBtn.setOnClickListener(view -> {
           showEditText.setVisibility(View.VISIBLE);
        });
    }
}