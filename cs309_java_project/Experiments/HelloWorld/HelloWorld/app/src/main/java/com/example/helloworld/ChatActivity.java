package com.example.helloworld;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class ChatActivity extends AppCompatActivity {

    Button b1, b2;
    EditText e1, e2;
    TextView t1;
    WebSocketClient cc;
    String text;
    ListView listView;
    List<ChatBubble> ChatBubbles;
    ArrayAdapter<ChatBubble> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ChatBubbles = new ArrayList<>();
        listView = (ListView) findViewById(R.id.recycler);

        b1 = (Button)findViewById(R.id.button11);
        b2 = (Button)findViewById(R.id.button22);
        e1 = (EditText)findViewById(R.id.editText1);
        e2 = (EditText)findViewById(R.id.editText229);
        t1 = (TextView)findViewById(R.id.textViewchat);
        t1.setMovementMethod(new ScrollingMovementMethod());

        adapter = new MessageAdapter(this, R.layout.left_chat_bubble, ChatBubbles);
        listView.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Draft[] drafts = new Draft[]{new Draft_6455()};



                text = e1.getText().toString();


                /**
                 * If running this on an android device, make sure it is on the same network as your
                 * computer, and change the ip address to that of your computer.
                 * If running on the emulator, you can use localhost.
                 */
                String w = "ws://coms-309-rp-02.cs.iastate.edu:8080/chat/" + text +e1.getText().toString();


                cc = null;
                try {
                    Log.d("Socket:", "Trying socket");
                    cc = new WebSocketClient(new URI(w),(Draft) drafts[0]) {
                        @Override
                        public void onMessage(String message) {


                            Log.d("", "run() returned: " + message);
                            String s=t1.getText().toString();

                            ChatBubble cb = new ChatBubble(s);
                            ChatBubbles.add(cb);
                            adapter.notifyDataSetChanged();
                            //t1.setText("hello world");
                            //Log.d("first", "run() returned: " + s);
                            //s=t1.getText().toString();
                            //Log.d("second", "run() returned: " + s);
                            t1.setText(s+" Server:"+message);
                        }

                        @Override
                        public void onOpen(ServerHandshake handshake) {
                            Log.d("OPEN", "run() returned: " + "is connecting");
                        }

                        @Override
                        public void onClose(int code, String reason, boolean remote) {
                            Log.d("CLOSE", "onClose() returned: " + reason);
                        }

                        @Override
                        public void onError(Exception e)
                        {
                            Log.d("Exception:", e.toString());
                        }
                    };
                }
                catch (URISyntaxException e) {
                    Log.d("Exception:", e.getMessage().toString());
                    e.printStackTrace();
                }
                cc.connect();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatBubble cb = new ChatBubble(e2.getText().toString());
                ChatBubbles.add(cb);
                adapter.notifyDataSetChanged();
                e2.setText("");
                try {
                    cc.send(e2.getText().toString());
                    //ask mitra, where does cc come from????
                }
                catch (Exception e)
                {
                    Log.d("ExceptionSendMessage:", e.getMessage().toString());
                }
            }
        });


    }

    private void connectWebSocket() {

    }

}
