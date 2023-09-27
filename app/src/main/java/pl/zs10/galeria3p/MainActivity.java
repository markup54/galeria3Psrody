package pl.zs10.galeria3p;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button_wstecz;
    private Button button_dalej;
    private Button button_pokaz;
    private ImageView imageView;
    private EditText editText;
    private boolean czyUkryty = false;
    private int aktualny = 0;
    ArrayList<Integer> obrazki = new ArrayList<>();

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("LICZNIK",aktualny);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Stan","uruchomiono metodę onCreate");

        obrazki.add(R.drawable.obraz1);
        obrazki.add(R.drawable.obraz2);
        obrazki.add(R.drawable.obraz3);
        obrazki.add(R.drawable.obraz4);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        button_wstecz = findViewById(R.id.button2);
        button_dalej = findViewById(R.id.button3);
        button_pokaz = findViewById(R.id.button4);
        editText = findViewById(R.id.editTextNumber);

        if(savedInstanceState !=null){
            aktualny = savedInstanceState.getInt("LICZNIK");
            pokazObraz(aktualny);
        }

        button_pokaz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        aktualny = Integer.valueOf(editText.getText().toString());
                        if(aktualny<0 || aktualny>obrazki.size()-1){
                            Toast.makeText(MainActivity.this, "Nie ma takiego obrazu", Toast.LENGTH_SHORT).show();
                            aktualny = 0;
                        }
                        pokazObraz(aktualny);
                    }
                }
        );

        button_dalej.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        aktualny++;
                        if(aktualny == obrazki.size())
                            aktualny =0;
                        pokazObraz(aktualny);
                    }
                }
        );
        button_wstecz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        aktualny--;
                        if(aktualny<0)
                        {
                            aktualny = obrazki.size()-1;
                        }
                        pokazObraz(aktualny);
                    }
                }
        );
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(czyUkryty){
                            imageView.setVisibility(View.VISIBLE);
                            button.setText(R.string.ukryj_obraz);
                            czyUkryty = false;
                        }
                        else {
                            imageView.setVisibility(View.INVISIBLE);
                            button.setText(R.string.poka_obraz);
                            czyUkryty = true;
                        }
                    }
                }
        );
    }
    private void pokazObraz(int i){
        imageView.setImageResource(obrazki.get(i));
        imageView.setVisibility(View.VISIBLE);
    }
}