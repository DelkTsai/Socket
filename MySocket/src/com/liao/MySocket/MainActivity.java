package com.liao.MySocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button bt;//打印按钮
	private EditText et;//输入IP
	private Context context;
	//----------socket相关类------------

	private String ip;
	private String WriterLine="true";//要传的数据

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysocket);
		init();
		//        et.addTextChangedListener(watcher);
		//        connect();
		
		ip="192.168.199.133";
		BtListener();

	}

	//    private TextWatcher watcher = new TextWatcher(){
	//
	//		@Override
	//		public void afterTextChanged(Editable ET) {
	//			// TODO Auto-generated method stub
	//			ip = et.getText().toString();
	//	        if(!ip.equals("")){
	//	        	
	//	        		connect();
	//	        	
	//	        	if(socket != null){
	//	        		try {
	//						socket.close();
	//					} catch (IOException e) {
	//						// TODO Auto-generated catch block
	//						e.printStackTrace();
	//					}
	//	        	}
	//	        		
	////	        	BtListener();
	//	        }else{
	//	        	Toast.makeText(context, "请输入IP", Toast.LENGTH_SHORT).show();
	//	        }
	//		}

	//		@Override
	//		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
	//				int arg3) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//
	//		@Override
	//		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
	//				int arg3) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//    	
	//    };

	private void BtListener() {
		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				connect();
			}
		});
	}

	private void connect() {
		AsyncTask<Void, String, Void> wt = new AsyncTask<Void, String, Void>(){

			private Socket socket;
			private BufferedWriter writer;
			private BufferedReader reader;
			@Override
			protected Void doInBackground(Void... arg0) {
				try {
					ip = et.getText().toString();
					socket = new Socket(ip,8899);
					//输出流
					writer = new BufferedWriter(
							new OutputStreamWriter(
									socket.getOutputStream()));
					//读取数据
					reader = new BufferedReader(
							new InputStreamReader(
									socket.getInputStream()));
					try {
						writer.write(WriterLine.replace("\n", " ")+"\n");
						writer.flush();
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}

		};
		wt.execute();

	}
	private void init() {
		bt = (Button) findViewById(R.id.bt);
		et = (EditText) findViewById(R.id.et);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//		if(socket.isConnected()){
		//			try {
		//				socket.close();
		//			} catch (IOException e) {
		//				e.printStackTrace();
		//			}
		//		}

	}
}
