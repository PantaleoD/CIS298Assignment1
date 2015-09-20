// This Code displays a form with 4 objects:  Add/Subtract Buttons, Counter Display & Message when
//  value is equal to or over 20. When < 20 the message does not show.

// Program adds or subtracts 1 and displays the value in counter_text

package edu.kvcc.cis298.cis298assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity {

     private Button mAddButton;                   // button variable
     private Button mSubtractButton;

      private  Integer counterInteger = 0;          // counter variable

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);         // display xml (?)

        // ADD BUTTON PROCESSING:
        // assign casted add_button created in xml
        // findViewById method holds views, referenced by ID
        mAddButton = (Button) findViewById(R.id.add_button);

        mAddButton.setOnClickListener(new View.OnClickListener()  // when realized CLICKED - creates new instance
        {                                                         //  and completesthe OnClick Method work
            @Override
            public void onClick(View v)        // when ADD clicked this occurs, w/in listeners new instance
            {
                counterInteger++;
                CastNDisplay();               // Calls Method to cast & text display; these 2 lines
  //  CastNDisplay is this:             final TextView txtValue = (TextView)findViewById(R.id.counter_text);
  //                                    txtValue.setText(Integer.toString(counterInteger));
        // when > 20 ... Toast shows over_20 message (over_20 defined in strings/ laid out in activity_counter)
                 if (counterInteger >= 20)
                    Toast.makeText(CounterActivity.this, R.string.over_20, Toast.LENGTH_SHORT).show();
            }
        }      );

// SUBTRACT BUTTON PROCESSING:
        //      cast subtract button & with listener instantiates instance & OnClick method executes
        mSubtractButton = (Button) findViewById(R.id.subtract_button);
        mSubtractButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) 
            {
                counterInteger--;

                CastNDisplay();

                  if (counterInteger < 20)
                      Toast.makeText(CounterActivity.this,"", Toast.LENGTH_SHORT).show();
            }
        });
      }

    //              Called Method:  creates text Value variable to cast counter_text to a TextView
    //                      and assign to txtValue.
    //                              Then... set the text Value variable to a string casted counterInteger
    private  void  CastNDisplay()
    {
        TextView displayTextValue =  (TextView)findViewById(R.id.counter_text);
        displayTextValue.setText(Integer.toString(counterInteger));
    }

    //   Function that occurs at start of the program execution
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //  Function & Uses the action_settings that is a default set up in strings.xml
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
