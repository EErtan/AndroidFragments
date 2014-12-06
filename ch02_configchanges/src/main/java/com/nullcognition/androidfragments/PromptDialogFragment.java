package com.nullcognition.androidfragments;

public class PromptDialogFragment extends android.app.DialogFragment implements android.view.View.OnClickListener {

   public static com.nullcognition.androidfragments.PromptDialogFragment newInstance(String prompt){
	  com.nullcognition.androidfragments.PromptDialogFragment pdf = new com.nullcognition.androidfragments.PromptDialogFragment();
	  android.os.Bundle bundle = new android.os.Bundle();
	  bundle.putString("prompt", prompt);
	  pdf.setArguments(bundle);

	  return pdf;
   }

   @Override
   public void onAttach(android.app.Activity act){
	  // If the activity we're being attached to has
	  // not implemented the OnDialogDoneListener
	  // interface, the following line will throw a
	  // ClassCastException. This is the earliest we
	  // can test if we have a well-behaved activity.
	  try{
		 OnDialogDoneListener test = (OnDialogDoneListener)act;
	  }
	  catch(ClassCastException cce){
		 // Here is where we fail gracefully.
		 android.util.Log.e(MainActivity.TAG, "Activity is not listening");
	  }
	  super.onAttach(act);
   }

   @Override
   public void onCreate(android.os.Bundle icicle){
	  super.onCreate(icicle);
	  this.setCancelable(true);
	  int style = android.app.DialogFragment.STYLE_NORMAL, theme = 0;
	  setStyle(style, theme);
   }

   public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, android.os.Bundle icicle){
	  android.view.View v = inflater.inflate(com.nullcognition.ch02_configchanges.R.layout.prompt_dialog, container, false);

	  android.widget.TextView tv = (android.widget.TextView)v.findViewById(com.nullcognition.ch02_configchanges.R.id.promptmessage);
	  tv.setText(getArguments().getString("prompt"));

	  android.widget.Button dismissBtn = (android.widget.Button)v.findViewById(com.nullcognition.ch02_configchanges.R.id.btn_dismiss);
	  dismissBtn.setOnClickListener(this);

	  android.widget.Button saveBtn = (android.widget.Button)v.findViewById(com.nullcognition.ch02_configchanges.R.id.btn_save);
	  saveBtn.setOnClickListener(this);

	  android.widget.Button helpBtn = (android.widget.Button)v.findViewById(com.nullcognition.ch02_configchanges.R.id.btn_help);
	  helpBtn.setOnClickListener(this);

	  return v;
   }

   @Override
   public void onCancel(android.content.DialogInterface di){
	  android.util.Log.v(MainActivity.TAG, "in onCancel() of PDF");
	  super.onCancel(di);
   }

   @Override
   public void onDismiss(android.content.DialogInterface di){
	  android.util.Log.v(MainActivity.TAG, "in onDismiss() of PDF");
	  super.onDismiss(di);
   }

   public void onClick(android.view.View v){
	  OnDialogDoneListener act = (OnDialogDoneListener)getActivity();
	  if(v.getId() == com.nullcognition.ch02_configchanges.R.id.btn_save){
		 android.widget.TextView tv = (android.widget.TextView)getView().findViewById(com.nullcognition.ch02_configchanges.R.id.inputtext);
		 act.onDialogDone(this.getTag(), false, tv.getText());
		 dismiss();
		 return;
	  }
	  if(v.getId() == com.nullcognition.ch02_configchanges.R.id.btn_dismiss){
		 act.onDialogDone(this.getTag(), true, null);
		 dismiss();
		 return;
	  }
	  if(v.getId() == com.nullcognition.ch02_configchanges.R.id.btn_help){
		 android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
		 ft.remove(this);

		 // in this case, we want to show the help text, but
		 // come back to the previous dialog when we're done
		 ft.addToBackStack(null);
		 //null represents no name for the back stack transaction

		 HelpDialogFragment hdf = HelpDialogFragment.newInstance(com.nullcognition.ch02_configchanges.R.string.help1);
		 hdf.show(ft, com.nullcognition.androidfragments.MainActivity2.DialogHelperClass.HELP_DIALOG_TAG);
		 return;
	  }
   }
}
