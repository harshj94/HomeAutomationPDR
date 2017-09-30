package jain.autorotatetesting.Fragments;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import jain.autorotatetesting.R;

/**
 * Created by harsh on 17-Mar-17.
 * Mobile: +91-916 800 4402
 */

public class BedRoom extends Fragment {

    Button[] button = new Button[10];
    String[] status = new String[9];
    SeekBar[] seekBars = new SeekBar[3];
    ImageView imageView;
    Drawable drawable;
    int callingButton = 0;
    String colorHex;
    Resources res;
    String ip = "http://192.168.1.50:8000/status/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bed_room, container, false);

        button[0] = (Button) view.findViewById(R.id.button1);
        button[1] = (Button) view.findViewById(R.id.button2);
        button[2] = (Button) view.findViewById(R.id.button3);
        button[3] = (Button) view.findViewById(R.id.button4);
        button[4] = (Button) view.findViewById(R.id.button5);
        button[5] = (Button) view.findViewById(R.id.button6);
        button[6] = (Button) view.findViewById(R.id.button7);
        button[7] = (Button) view.findViewById(R.id.button8);
        button[8] = (Button) view.findViewById(R.id.button9);
        button[9] = (Button) view.findViewById(R.id.pickColor);

        seekBars[0] = (SeekBar) view.findViewById(R.id.seekBar1);
        seekBars[1] = (SeekBar) view.findViewById(R.id.seekBar2);
        seekBars[2] = (SeekBar) view.findViewById(R.id.seekBar3);

        imageView = (ImageView) view.findViewById(R.id.colorPicked);
        res = getResources();
        drawable = res.getDrawable(R.drawable.circle);

        for (int i = 0; i < 9; i++) {
            if (status[i] == null || status[i].equals("")) {
                status[i] = "100";
            }
        }

        new GetStatus().execute(ip + "getstatus/1");

        button[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callingButton = 0;
                //current state off; turning on
                if (status[0].equals("0")) {
                    new AccessURL().execute(ip + "s1/1");
                }
                //current state on; turning off
                else if (status[0].equals("1")) {
                    new AccessURL().execute(ip + "s1/0");
                }
            }
        });
        button[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callingButton = 1;
                //current state off; turning on
                if (status[1].equals("0")) {
                    new AccessURL().execute(ip + "s2/1");
                }
                //current state on; turning off
                else if (status[1].equals("1")) {
                    new AccessURL().execute(ip + "s2/0");
                }
            }
        });
        button[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callingButton = 2;
                //current state off; turning on
                if (status[2].equals("0")) {
                    new AccessURL().execute(ip + "s3/1");
                }
                //current state on; turning off
                else if (status[2].equals("1")) {
                    new AccessURL().execute(ip + "s3/0");
                }
            }
        });
        button[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callingButton = 3;
                //current state off; turning on
                if (status[3].equals("0")) {
                    new AccessURL().execute(ip + "s4/1");
                }
                //current state on; turning off
                else if (status[3].equals("1")) {
                    new AccessURL().execute(ip + "s4/0");
                }
            }
        });
        button[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callingButton = 4;
                //current state off; turning on
                if (status[4].equals("0")) {
                    new AccessURL().execute(ip + "s5/1");
                }
                //current state on; turning off
                else if (status[4].equals("1")) {
                    new AccessURL().execute(ip + "s5/0");
                }
            }
        });
        button[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callingButton = 5;
                //current state off; turning on
                if (status[5].equals("0")) {
                    new AccessURL().execute(ip + "s6/1");
                }
                //current state on; turning off
                else if (status[5].equals("1")) {
                    new AccessURL().execute(ip + "s6/0");
                }
            }
        });
        button[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callingButton = 6;
                //current state off; turning on
                if (status[6].equals("0")) {
                    new AccessURL().execute(ip + "s7/1");
                }
                //current state on; turning off
                else if (status[6].equals("1")) {
                    new AccessURL().execute(ip + "s7/0");
                }
            }
        });
        button[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callingButton = 7;
                //current state off; turning on
                if (status[7].equals("0")) {
                    new AccessURL().execute(ip + "s8/1");
                }
                //current state on; turning off
                else if (status[7].equals("1")) {
                    new AccessURL().execute(ip + "s8/0");
                }
            }
        });

        button[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callingButton = 8;
                //current state off; turning on
                if (status[8].equals("0")) {
                    new AccessURL().execute(ip + "s9/1");
                }
                //current state on; turning off
                else if (status[8].equals("1")) {
                    new AccessURL().execute(ip + "s9/0");
                }
            }
        });

        button[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callingButton = 9;

                ColorPickerDialogBuilder
                        .with(getActivity(), R.style.MyAlertDialogStyle)
                        .setTitle("Choose color")
                        .lightnessSliderOnly()
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(12)
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {
                            }
                        })
                        .setPositiveButton("ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                                colorHex = Integer.toHexString(selectedColor).substring(2);
                                new AccessURL().execute(ip + "c1/" + colorHex);
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .build()
                        .show();

            }
        });

        //seekBar1
        seekBars[0].setOnTouchListener(new SeekBar.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle SeekBar touch events.
                v.onTouchEvent(event);
                return true;
            }
        });

        seekBars[0].setMax(5);
        seekBars[0].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                callingButton = 10;
                new AccessURL().execute(ip + "d1/" + i);
                if (i > 0) {
                    seekBars[0].setThumb(res.getDrawable(R.drawable.red_scrubber_control));
                } else {
                    seekBars[0].setThumb(res.getDrawable(R.drawable.white_control));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //seekBar2
        seekBars[1].setOnTouchListener(new SeekBar.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle SeekBar touch events.
                v.onTouchEvent(event);
                return true;
            }
        });

        seekBars[1].setMax(5);
        seekBars[1].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                callingButton = 11;
                new AccessURL().execute(ip + "d2/" + i);
                if (i > 0) {
                    seekBars[1].setThumb(res.getDrawable(R.drawable.red_scrubber_control));
                } else {
                    seekBars[1].setThumb(res.getDrawable(R.drawable.white_control));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //seekBar3
        seekBars[2].setOnTouchListener(new SeekBar.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle SeekBar touch events.
                v.onTouchEvent(event);
                return true;
            }
        });

        seekBars[2].setMax(5);
        seekBars[2].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                callingButton = 12;
                new AccessURL().execute(ip + "d3/" + i);
                if (i > 0) {
                    seekBars[2].setThumb(res.getDrawable(R.drawable.red_scrubber_control));
                } else {
                    seekBars[2].setThumb(res.getDrawable(R.drawable.white_control));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }

    private class AccessURL extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            StringBuilder sb = null;
            BufferedReader reader = null;
            String serverResponse = null;
            try {
                String urlString = params[0];
                URL url = new URL(urlString);
                Log.d("urlString", urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setConnectTimeout(5000);
                connection.setRequestMethod("GET");
                connection.connect();
                int statusCode = connection.getResponseCode();
                Log.d("statusCode", "" + statusCode);
                if (statusCode == 200) {
                    sb = new StringBuilder();
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                }

                connection.disconnect();
                if (sb != null)
                    serverResponse = sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            return serverResponse;
        }

        @Override
        protected void onPostExecute(String serverResponse) {
            super.onPostExecute(serverResponse);
            if (serverResponse != null) {
                Log.d("URL response", serverResponse);
                Log.d("Calling button", "Value = " + callingButton);
                if (callingButton >= 0 && callingButton <= 8) {
                    if (status[callingButton].equals("0")) {
                        status[callingButton] = "1";
                        if (callingButton != 8) {
                            button[callingButton].setCompoundDrawablesWithIntrinsicBounds(R.drawable.sunyellow, 0, 0, 0);
                        } else {
                            button[callingButton].setCompoundDrawablesWithIntrinsicBounds(R.drawable.dooryellow, 0, 0, 0);
                        }
                    } else if (status[callingButton].equals("1")) {
                        status[callingButton] = "0";
                        if (callingButton != 8) {
                            button[callingButton].setCompoundDrawablesWithIntrinsicBounds(R.drawable.sun, 0, 0, 0);
                        } else {
                            button[callingButton].setCompoundDrawablesWithIntrinsicBounds(R.drawable.doorwhite, 0, 0, 0);
                        }
                    }
                    callingButton = 0;
                } else if (callingButton == 9) {
                    drawable.setColorFilter(Color.parseColor("#" + colorHex), PorterDuff.Mode.SRC_ATOP);
                    imageView.setImageDrawable(drawable);
                }
            } else {
                Log.d("URL response", " is null");
                if (isAdded()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Communication Failure!!!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private class GetStatus extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            StringBuilder sb = null;
            BufferedReader reader = null;
            String serverResponse = null;
            try {
                String urlString = params[0];
                URL url = new URL(urlString);
                Log.d("urlString", urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setConnectTimeout(5000);
                connection.setRequestMethod("GET");
                connection.connect();
                int statusCode = connection.getResponseCode();
                Log.d("statusCode", "" + statusCode);
                if (statusCode == 200) {
                    sb = new StringBuilder();
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                }

                connection.disconnect();
                if (sb != null)
                    serverResponse = sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            return serverResponse;
        }

        @Override
        protected void onPostExecute(String serverResponse) {
            super.onPostExecute(serverResponse);
            if (serverResponse != null) {
                Log.d("URL response", serverResponse);
                JSONObject jObject;
                try {
                    jObject = new JSONObject(serverResponse);
                    JSONArray jArray = jObject.getJSONArray("status");
                    for (int i = 0; i <= 8; i++) {
                        status[i] = jArray.get(i).toString();
                        if (status[i].equals("0")) {
                            button[i].setCompoundDrawablesWithIntrinsicBounds(R.drawable.sun, 0, 0, 0);
                        } else if (status[i].equals("1")) {
                            button[i].setCompoundDrawablesWithIntrinsicBounds(R.drawable.sunyellow, 0, 0, 0);
                        }
                    }
                    for (int i = 9; i <= 11; i++) {
                        seekBars[i - 9].setProgress(Integer.parseInt(jArray.get(i).toString()));
                        if (Integer.parseInt(jArray.get(i).toString()) > 0) {
                            seekBars[i-9].setThumb(res.getDrawable(R.drawable.red_scrubber_control));
                        } else {
                            seekBars[i-9].setThumb(res.getDrawable(R.drawable.white_control));
                        }
                    }

                    drawable.setColorFilter(Color.parseColor("#" + jArray.get(12).toString()), PorterDuff.Mode.SRC_ATOP);
                    imageView.setImageDrawable(drawable);

                } catch (JSONException e) {
                    e.printStackTrace();
                    if (isAdded()) {
                        Toast.makeText(getActivity().getApplicationContext(), "Sorry, something unexpected happened :(", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Log.d("URL response", " is null");
                if (isAdded()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Communication Failure!!!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}