//package com.example.retretku;
//
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//import com.google.firebase.storage.UploadTask;
//import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback;
//import com.midtrans.sdk.corekit.core.LocalDataHandler;
//import com.midtrans.sdk.corekit.core.MidtransSDK;
//import com.midtrans.sdk.corekit.core.TransactionRequest;
//import com.midtrans.sdk.corekit.core.themes.CustomColorTheme;
//import com.midtrans.sdk.corekit.models.ItemDetails;
//import com.midtrans.sdk.corekit.models.UserAddress;
//import com.midtrans.sdk.corekit.models.UserDetail;
//import com.midtrans.sdk.corekit.models.snap.TransactionResult;
//import com.midtrans.sdk.uikit.SdkUIFlowBuilder;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//import static android.app.Activity.RESULT_OK;
//
//public class UserProfileFragment extends Fragment  {
//
//    TextView tv_nama,tv_alamat,tv_email;
//    EditText et_pass,et_cpass;
//    Button btn_submit;
//    ImageView iv_gambar;
//
//    FirebaseAuth mAuth;
//    private StorageReference mStorageRef;
//    private ProgressDialog pDialog;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.userprofile_fragment, container,false);
//
//        tv_nama = v.findViewById(R.id.tv_nama);
//        tv_alamat = v.findViewById(R.id.tv_alamat);
//        tv_email = v.findViewById(R.id.tv_email);
//        et_pass = v.findViewById(R.id.et_pass);
//        et_cpass = v.findViewById(R.id.et_cpass);
//        btn_submit = v.findViewById(R.id.btn_submit);
//        iv_gambar = v.findViewById(R.id.iv_profile);
//
//        mAuth = FirebaseAuth.getInstance();
//        mStorageRef = FirebaseStorage.getInstance().getReference();
//
//        tv_email.setText(mAuth.getCurrentUser().getEmail());
//
//        initMid();
//
//        /*btn_submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //ganti pass
//                final String pass = et_pass.getText().toString();//new password
//                String cpass = et_cpass.getText().toString();//old password
//
//                pDialog = new ProgressDialog(getContext());
//                pDialog.setMessage("Memuat");
//                pDialog.show();
//
//                if(!pass.isEmpty()&&!cpass.isEmpty()){
//                    final FirebaseUser firebaseUser = mAuth.getCurrentUser();
//                    String email = firebaseUser.getEmail();
//                    AuthCredential credential = EmailAuthProvider.getCredential(email,cpass);
//
//                    firebaseUser.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if(task.isSuccessful()){
//                                firebaseUser.updatePassword(pass).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<Void> task) {
//                                        if(task.isSuccessful()){
//                                            Toasty.success(getContext(),"Password Berhasil Diubah!", Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//                                });
//                            }
//                            else{
//                                System.out.println("authentication failed");
//                            }
//                            pDialog.dismiss();
//                        }
//                    });
//                }
//                else{
//                    //kalau tidak diisi maka akan simpan ke gambar ke database
//                }
//            }
//        });*/
//
//        btn_submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //ini masih coba" jangan diganti" dulu
//                transactionRequester();
//                //MidtransSDK.getInstance().startPaymentUiFlow(getContext(), PaymentMethod.BANK_TRANSFER);
//            }
//        });
//
//        iv_gambar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent();
//                i.setType("image/*");
//                i.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(i,"pilih gambar"),1);
//            }
//        });
//
//        //ini cara ambil gambar
//        StorageReference gsReference = FirebaseStorage.getInstance().getReferenceFromUrl("gs://retretku.appspot.com/images/"+mAuth.getCurrentUser().getUid()+".jpg");
//        gsReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                Picasso.get().load(uri).into(iv_gambar);
//            }
//        });
//
//        return v;
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//         if(requestCode == 1 && resultCode == RESULT_OK){
//             Uri selectedImage = data.getData();
//             //iv_gambar.setImageURI(selectedImage);
//             upload(selectedImage);
//         }
//    }
//
//    //method untuk upload gambar
//    public void upload(final Uri selectedImage){
//        final Uri file  = selectedImage;
//        StorageReference ref = mStorageRef.child("images/"+mAuth.getCurrentUser().getUid()+".jpg");
//        ref.putFile(file).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                iv_gambar.setImageURI(file);
//            }
//        });
//    }
//
//    private void initMid() {
//        //benda ini masih gabisa jalan
//        SdkUIFlowBuilder.init()
//                .setClientKey("SB-Mid-client-7zZs4-dYyNoec7oL") // client_key is mandatory
//                .setContext(getContext()) // context is mandatory
//                .setTransactionFinishedCallback(new TransactionFinishedCallback() {
//                    @Override
//                    public void onTransactionFinished(TransactionResult result) {
//
//                    }
//                }) // set transaction finish callback (sdk callback)
//                .setMerchantBaseUrl("https://retretku.firebaseio.com/") //set merchant url (required)
//                .enableLog(true) // enable sdk log (optional)
//                .setColorTheme(new CustomColorTheme("#FFE51255", "#B61548", "#FFE51255")) // set theme. it will replace theme on snap theme on MAP ( optional)
//                .buildSDK();
//    }
//
//    private void transactionRequester() {
//        //benda ini juga
//        UserDetail userDetail = LocalDataHandler.readObject("user_details", UserDetail.class);
//        if (userDetail == null) {
//            userDetail = new UserDetail();
//            userDetail.setUserFullName("Ahmad Satiri");
//            userDetail.setEmail("bangtiray@gmail.com");
//            userDetail.setPhoneNumber("08123456789");
//            userDetail.setUserId("bangtiray-6789");
//
//            ArrayList<UserAddress> userAddresses = new ArrayList<>();
//            UserAddress userAddress = new UserAddress();
//            userAddress.setAddress("Jalan Andalas Gang Sebelah No. 1");
//            userAddress.setCity("Jakarta");
//            userAddress.setAddressType(com.midtrans.sdk.corekit.core.Constants.ADDRESS_TYPE_BOTH);
//            userAddress.setZipcode("12345");
//            userAddress.setCountry("IDN");
//            userAddresses.add(userAddress);
//            userDetail.setUserAddresses(userAddresses);
//            LocalDataHandler.saveObject("user_details", userDetail);
//        }
//
//        TransactionRequest transactionRequest = new TransactionRequest(System.currentTimeMillis() + "", 35000);
//        ItemDetails itemDetails1 = new ItemDetails("BP1", 15000, 1, "Bakso Paket 1");
//        ItemDetails itemDetails2 = new ItemDetails("BP2", 20000, 1, "Bakso Paket 1");
//
//
//        ArrayList<ItemDetails> itemDetailsList = new ArrayList<>();
//        itemDetailsList.add(itemDetails1);
//        itemDetailsList.add(itemDetails2);
//
//        transactionRequest.setItemDetails(itemDetailsList);
//        MidtransSDK.getInstance().setTransactionRequest(transactionRequest);
//    }
//
//
//
//
//
//
//}
