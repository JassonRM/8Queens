package jassonrm.a8queens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class Board extends AppCompatActivity {

    private Button startBtn;

    private GridView boardGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        boardGrid = findViewById(R.id.board);
        boardGrid.setAdapter(new ImageAdapter(this));

        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("CLICKED");
                Queens.start();
                ImageAdapter adapter = (ImageAdapter) boardGrid.getAdapter();
                adapter.notifyDataSetChanged();
            }
        });

    }
}
