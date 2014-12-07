package com.nullcognition.androidfragments;

public class TimePickerFragment extends android.app.DialogFragment
    implements android.app.TimePickerDialog.OnTimeSetListener {

    private OnDialogDoneListener dialogClient;

    @Override
    public android.app.Dialog onCreateDialog(android.os.Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final java.util.Calendar c = java.util.Calendar.getInstance();
        int hour = c.get(java.util.Calendar.HOUR_OF_DAY);
        int minute = c.get(java.util.Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new android.app.TimePickerDialog(getActivity(), this, hour, minute,
            android.text.format.DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
    	String timeStr = String.format("%02d", hourOfDay) + ":" 
                + String.format("%02d", minute);
	    dialogClient.onDialogDone(getTag(), false, timeStr);
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
