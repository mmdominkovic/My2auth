package ba.sum.fpmoz.my2auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ba.sum.fpmoz.my2auth.databinding.ActivityProfile2Binding;

public class ProfileActivity2 extends AppCompatActivity {

FirebaseAuth firebaseAuth;
private ActivityProfile2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfile2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth=FirebaseAuth.getInstance();
        checkUserStatus();

        binding.logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                checkUserStatus();
            }
        });

    }

    private void checkUserStatus() {
        FirebaseUser firebaseUser =firebaseAuth.getCurrentUser();
        if (firebaseUser !=null){
            String phone = firebaseUser.getPhoneNumber();
            binding.phoneTv.setText(phone);
        } else{
            finish();
        }
    }
}