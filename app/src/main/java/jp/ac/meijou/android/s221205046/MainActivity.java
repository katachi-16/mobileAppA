package jp.ac.meijou.android.s221205046;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import jp.ac.meijou.android.s221205046.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private PrefDataStore prefDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefDataStore = PrefDataStore.getInstance(this);

        binding.saveButton.setOnClickListener(view ->{
            var text = binding.editTextText.getText().toString();
            prefDataStore.setString("name", text);
        });

        //binding.showText.setText(R.string.showText);

        binding.button.setOnClickListener(view -> {
            float newSize = 24;
            binding.showText.setTextSize(newSize);
        });

        binding.button2.setOnClickListener(view -> {
            binding.imageView.setImageResource(R.drawable.baseline_castle_24);
        });

        binding.button3.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
        });

        binding.editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // テキストが更新される直前に呼ばれる
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 文字を1つ入力された時に呼ばれる
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // テキストが更新されたあとに呼ばれる
                binding.showText.setText(editable.toString());
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        prefDataStore.getString("name")
                .ifPresent(name -> binding.showText.setText(name));

    }
}