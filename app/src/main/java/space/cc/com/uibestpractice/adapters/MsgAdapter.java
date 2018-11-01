package space.cc.com.uibestpractice.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import space.cc.com.uibestpractice.R;
import space.cc.com.uibestpractice.domain.bizObject.Msg;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg>  msgList;

    public MsgAdapter(List<Msg> msgList) {
        this.msgList = msgList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leftLayout=itemView.findViewById(R.id.left_layout);
            rightLayout=itemView.findViewById(R.id.right_layout);
            leftMsg=itemView.findViewById(R.id.left_msg);
            rightMsg=itemView.findViewById(R.id.right_msg);
        }
    }
    @NonNull
    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View  view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.msg_item,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MsgAdapter.ViewHolder viewHolder, int position) {
       Msg msg=msgList.get(position);
       if(msg.getType()==Msg.TYPE_RECEIVED){
           viewHolder.leftLayout.setVisibility(View.VISIBLE);
           viewHolder.rightLayout.setVisibility(View.GONE);
           viewHolder.leftMsg.setText(msg.getContent());
       }else if(msg.getType()==Msg.TYPE_SENT){
           viewHolder.rightLayout.setVisibility(View.VISIBLE);
           viewHolder.leftLayout.setVisibility(View.GONE);
           viewHolder.rightMsg.setText(msg.getContent());
       }
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

}
