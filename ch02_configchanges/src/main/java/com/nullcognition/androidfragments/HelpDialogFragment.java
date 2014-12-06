package com.nullcognition.androidfragments;

public class HelpDialogFragment extends android.app.DialogFragment implements android.view.View.OnClickListener {

   public static com.nullcognition.androidfragments.HelpDialogFragment newInstance(int helpResId){
	  com.nullcognition.androidfragments.HelpDialogFragment hdf = new com.nullcognition.androidfragments.HelpDialogFragment();
	  android.os.Bundle bundle = new android.os.Bundle();
	  bundle.putInt("help_resource", helpResId);
	  hdf.setArguments(bundle);

	  return hdf;
   }

   @Override
   public void onCreate(android.os.Bundle icicle){
	  super.onCreate(icicle);
	  this.setCancelable(true);
	  int style = android.app.DialogFragment.STYLE_NORMAL, theme = 0;
	  setStyle(style, theme);
   }

   public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, android.os.Bundle icicle){

	  android.view.View v = inflater.inflate(com.nullcognition.ch02_configchanges.R.layout.help_dialog, container, false);

	  android.widget.TextView tv = (android.widget.TextView)v.findViewById(com.nullcognition.ch02_configchanges.R.id.helpmessage);
	  tv.setText(getActivity().getResources().getText(getArguments().getInt("help_resource")));

	  android.widget.Button closeBtn = (android.widget.Button)v.findViewById(com.nullcognition.ch02_configchanges.R.id.btn_close);
	  closeBtn.setOnClickListener(this);
	  return v;
   }

   public void onClick(android.view.View v){
	  dismiss();
   }
}
