package space.cc.com.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import space.cc.com.uibestpractice.adapters.MsgAdapter;
import space.cc.com.uibestpractice.domain.bizObject.Msg;

public class MainActivity extends AppCompatActivity {
    private List<Msg>  list=new ArrayList<>();

    private EditText inputText;
    private Button sendBut;
    private RecyclerView msgRecycleView;
    private MsgAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMsgs();
         inputText = findViewById(R.id.text_send);
        sendBut = findViewById(R.id.send_msg_but);
        msgRecycleView=findViewById(R.id.msg_recy_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        msgRecycleView.setLayoutManager(layoutManager);
        adapter =new MsgAdapter(list);
        msgRecycleView.setAdapter(adapter);
        sendBut.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String content=inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SENT);
                    list.add(msg);
                    int newestPosition=list.size()-1;
                    // 有新消息时 刷新listView的显示
                    adapter.notifyItemInserted(newestPosition);
                    //listView定位到最新消息位置
                    msgRecycleView.scrollToPosition(newestPosition);
                    //清空输入框
                    inputText.setText("");
                }


            }
        });



    }

    private void initMsgs() {

        Msg msg1=new Msg("hello cc",Msg.TYPE_RECEIVED);
        Msg msg2=new Msg("hello yy",Msg.TYPE_SENT);
        Msg msg3=new Msg("nice weather ,ah",Msg.TYPE_RECEIVED);
        list.add(msg1);
        list.add(msg2);
        list.add(msg3);
    }
}
