package com.example.jakubkalinowski.sharerydeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class PaymentActivity extends AppCompatActivity {

    //Firebase Reference
    Firebase wRootRef;
    Firebase ref = new Firebase("https://shareryde.firebaseio.com/");
    Firebase usersRef = ref.child("users");
    AuthData authData;
    String userID; // = ref.getAuth().getUid();

    //variables for all the components of the activity
    private EditText mEmailAddress;
    private EditText paymentAmount;
    private TextView userMoney;
    private Button submitPayment;
    private Button addCredit;
    private Button reedeemCredit;

    //variables for extracting values from components
    private String driversEmailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Firebase.setAndroidContext(this);

        wRootRef = new Firebase("https://shareryde.firebaseio.com");

        userMoney = (TextView)findViewById(R.id.userMoney);
        mEmailAddress = (EditText) findViewById(R.id.emailAddress);
        paymentAmount = (EditText) findViewById(R.id.paymentAmount);
        submitPayment = (Button) findViewById(R.id.subPayButton);
    }

    @Override
    protected void onStart() {
        super.onStart();

        authData = ref.getAuth();
        userID = wRootRef.getAuth().getUid();

        final Firebase walletRef = wRootRef.child("users").child((String)userID).child("wallet");//.child(userID);

        /**
         * TO DO: import user's money amount from firebase
         */
        walletRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String wallet = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String wallet = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String wallet = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                String wallet = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());

            }
        });

//        walletRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                /*
//                This is for a single value like users --> messages (only one child)
//                 */
////                String wallet = dataSnapshot.getValue(String.class);
////                userMoney.setText(wallet);
//                /******/
//
//                /*
//                Map is for object with more than one child
//                 */
////                Map<String, String> map = dataSnapshot.getValue(Map.class);
////                String wallet = map.get("wallet");
//                /******/
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });

        Firebase eRootRef = wRootRef.child("users");//.child(userID);


        submitPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /**
                 * get the amount entered and subtract it from the user then update the user wallet.(do this to passenger only, not the driver)
                 */
//                Firebase driverRef = wRootRef.child("users");//
//
//
//                double dCredit = Double.parseDouble(driversCredit);
//                double pCredit = 0;

//                String amount = "";
//
//
//
//                walletRef.child("wallet").setValue(amount);

//                Intent i = new Intent(PaymentActivity.this, PaymentActivity.class);
//                startActivity(i);
            }
        });


//        authData = ref.getAuth();
//        userID = ref.getAuth().getUid();
        //initializing activity components
//        mEmailAddress = (EditText) findViewById(R.id.emailAddress);
//        paymentAmount = (EditText) findViewById(R.id.paymentAmount);
//        userMoney = (TextView) findViewById(R.id.userMoney);
//        submitPayment = (Button) findViewById(R.id.subPayButton);
//        addCredit = (Button) findViewById(R.id.addCreditButton);
//        reedeemCredit = (Button) findViewById(R.id.reedeemCreditButton);

        /**
         * get wallet amount from firebase and set it to textview
         */

        //*****userMoney.setText(ref.child("users").child((String)userID).child("wallet").getKey()); // incorrect


        // Attach an listener to read the data at our posts reference
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//
//                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
//                    User post = postSnapshot.getValue(User.class);
//                    System.out.println(post.getWallet());
//                }
//            }
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//                System.out.println("The read failed: " + firebaseError.getMessage());
//            }
//        });

//        ref.addChildEventListener(new ChildEventListener() {
//            // Retrieve new posts as they are added to the database
//
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            // Get the data on a post that has changed
//            @Override
//            public void onChildChanged(DataSnapshot snapshot, String previousChildKey) {
//                String wallet = (String) snapshot.child("wallet").getValue();
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//                System.out.println("The read failed: " + firebaseError.getMessage());
//            }
//        });





            /**
             * Action for 'submitPayment'
             * Calculations and Firebase will be dealt with here
             */

//        submitPayment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                /**
//                 * TO DO: take the user's money reference and subtract the payment amount from it
//                 *          and store it back in the db
//                 */
//
//
//                /**
//                 * TO DO: fetch driver money amount from db, add the payment amount to it and store it back in the db
//                 */
//            }
//        });
    }
}
