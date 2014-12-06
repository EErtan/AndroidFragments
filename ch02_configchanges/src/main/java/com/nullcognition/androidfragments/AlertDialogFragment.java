package com.nullcognition.androidfragments;

public class AlertDialogFragment
extends android.app.DialogFragment
implements android.content.DialogInterface.OnClickListener
{
	public static com.nullcognition.androidfragments.AlertDialogFragment
    newInstance(String message)
	{
		com.nullcognition.androidfragments.AlertDialogFragment adf = new com.nullcognition.androidfragments.AlertDialogFragment();
		android.os.Bundle bundle = new android.os.Bundle();
		bundle.putString("alert-message", message);
		adf.setArguments(bundle);
		
		return adf;
	}
	
	@Override
	public void onAttach(android.app.Activity act) {
		// If the activity we're being attached to has
		// not implemented the OnDialogDoneListener
		// interface, the following line will throw a
		// ClassCastException. This is the earliest we
		// can test if we have a well-behaved activity.
		try {
            OnDialogDoneListener test = (OnDialogDoneListener)act;
		}
		catch(ClassCastException cce) {
			// Here is where we fail gracefully.
			android.util.Log.e(MainActivity.TAG, "Activity is not listening");
		}
		super.onAttach(act);
	}

    @Override    
    public void onCreate(android.os.Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
    	this.setCancelable(true);
        int style = android.app.DialogFragment.STYLE_NORMAL, theme = 0;
        setStyle(style,theme);
    }

    @Override    
    public android.app.Dialog onCreateDialog(android.os.Bundle savedInstanceState)
    {        
    	android.app.AlertDialog.Builder b =
    	    new android.app.AlertDialog.Builder(getActivity())
    	    .setTitle("Alert!!")
    	    .setPositiveButton("Ok", this)
    	    .setNegativeButton("Cancel", this)
    	    .setMessage(this.getArguments().getString("alert-message"));
    	return b.create();
    }

    public void onClick(android.content.DialogInterface dialog, int which)
    {
    	OnDialogDoneListener act = (OnDialogDoneListener) getActivity();
        boolean cancelled = false;
    	if (which == android.app.AlertDialog.BUTTON_NEGATIVE)
    	{
    		cancelled = true;
    	}
    	act.onDialogDone(getTag(), cancelled, "Alert dismissed");
    }
}
