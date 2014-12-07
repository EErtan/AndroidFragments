package com.nullcognition.androidfragments;

public class FixedDatePickerDialog extends android.app.DatePickerDialog {

	public FixedDatePickerDialog(android.content.Context context, android.app.DatePickerDialog.OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
		super(context, callBack, year, monthOfYear, dayOfMonth);
	}
		
	@Override
	protected void onStop() {
		// Do nothing since the super's implementation of this
		// method is what causes the problem.
	}
}
