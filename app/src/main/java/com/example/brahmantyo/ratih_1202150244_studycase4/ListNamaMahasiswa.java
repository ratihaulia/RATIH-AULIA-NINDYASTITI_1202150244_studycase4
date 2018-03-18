package com.example.brahmantyo.ratih_1202150244_studycase4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListNamaMahasiswa extends AppCompatActivity {

    //membuat array list nama mahasiswa
    private String[] nama = { "Nana","Ali", "Diana", "Nindya", "Brahma", "Manda", "Wawan", "Fikhi",
            "Sasa", "Ayu", "Lala", "Adi","Ramli", "Desy", "Nanang"};

    //mendeklarasikan ListView & Button
    ListView list_nama;
    Button btn_mulai;

    private static Parcelable mListViewScrollPos = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nama_mahasiswa);

        //mengambil id dari objek List View & Button
        list_nama = findViewById(R.id.listnama);
        btn_mulai = findViewById(R.id.btnmulai);

        //mengeset adapter array
        list_nama.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,new ArrayList<String>()));

        // Restore the ListView position
        if (mListViewScrollPos != null) {
            list_nama.onRestoreInstanceState(mListViewScrollPos);
        }


        btn_mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil class mytask dan mengeksekusinya
                new mytask().execute();
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the ListView position
        mListViewScrollPos = list_nama.onSaveInstanceState();
    }

    private class mytask extends AsyncTask<Void,String,String> {

        //mendeklarasikan Array Adapter, Progress Dialog & Count
        ArrayAdapter<String> adapter;
        ProgressDialog progressdialog;
        int count;

        @Override
        protected void onPreExecute() {

            //mengambil adapter dari array tersebut
            adapter = (ArrayAdapter<String>)list_nama.getAdapter();

            //membuat object progress dialog
            progressdialog = new ProgressDialog(ListNamaMahasiswa.this);
            //mengeset judul progress dialog
            progressdialog.setTitle("Loading Data");
            progressdialog.setProgressStyle(progressdialog.STYLE_HORIZONTAL);
            progressdialog.setMax(15);
            progressdialog.setProgress(0);
            //menampilkan progress dialog
            progressdialog.show();
            //memastikan bahwa hitungan sebelum di eksekusi adalah 0
            count = 0;
        }

        @Override
        protected String doInBackground(Void... voids) {
            //membuat perulangan untuk memunculkan nama mahasiswa
            for (String namamhs : nama){
                publishProgress(namamhs);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //mengembalikan nilai dengan tulisan
            return "semua nama sudah muncul";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //adapter array memluai dari array 0
            adapter.add(values[0]);
            //hitungan pada saat progress update bertambah
            count++;
            //mengeset hitungan di dalam progress dialog
            progressdialog.setProgress(count);
        }
        @Override
        protected void onPostExecute(String result) {
//menampilkan nilai dari return yang ada di method doInBackground
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
            //setelah loading progress sudah selesai maka progres dialog akan hilang secara otomatis
            progressdialog.hide();


        }



    }
}
