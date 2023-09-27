package pl.zs10.galeria3p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageView;
    private boolean czyUkryty = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(czyUkryty){
                            imageView.setVisibility(View.VISIBLE);
                            button.setText("Ukryj obrazek");
                            czyUkryty = false;
                        }
                        else {
                            imageView.setVisibility(View.INVISIBLE);
                            button.setText("Pokaż obrazek");
                            czyUkryty = true;
                        }
                    }
                }
        );
    }
}