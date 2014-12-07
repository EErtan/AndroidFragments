package com.nullcognition.androidfragments;

public class DatePickerFragment extends android.app.DialogFragment
    implements android.app.DatePickerDialog.OnDateSetListener {

    private OnDialogDoneListener dialogClient;

    @Override
    public android.app.Dialog onCreateDialog(android.os.Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final java.util.Calendar c = java.util.Calendar.getInstance();
        int year = c.get(java.util.Calendar.YEAR);
        int month = c.get(java.util.Calendar.MONTH);
        int day = c.get(java.util.Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        // See MainActivity.java for comments on bug 34833
        return new FixedDatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(android.widget.DatePicker view, int year, int month, int day) {
    	android.util.Log.d(MainActivity3.LOGTAG, "in onDateSet()");
        // Do something with the date chosen by the user
    	String dateStr = String.format("%02d", month+1) + "/" 
                + String.format("%02d", day) + "/"
                + String.format("%04d", year);
	    dialogClient.onDialogDone(getTag(), false, dateStr);
    }
	
	@Override
	public void onAttach(android.app.Activity act) {
		// If the activity we're being attached to has
		// not implemented the OnDialogDoneListener
		// interface, the following line will throw a
		// ClassCastException. This is the earliest we
		// can test if we have a well-behaved activity.
		try {
            dialogClient = (OnDialogDoneListener)act;
		}
		catch(ClassCastException cce) {
			// Here is where we fail gracefully.
			android.util.Log.e(MainActivity3.LOGTAG, "Activity is not listening");
		}
		super.onAttach(act);
	}
}
