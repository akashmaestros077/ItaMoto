package Other;
import java.util.List;

import Model.Addmeal;
import Model.BookTicket;
import Model.ChooseSeat;
import Model.ConfirmDetails;
import Model.ContactUs;
import Model.DropLocation;
import Model.EditProfile;
import Model.HomeDrop;
import Model.JourneyDetails;
import Model.LoginModel;
import Model.NewPassword;
import Model.OfferImage;
import Model.OtpVerify;
import Model.PassengerDetails;
import Model.PassengerList;
import Model.PayNow;
import Model.PaymentDetails;
import Model.PickupLocation;
import Model.SearchResult;
import Model.SeatAvailable;
import Model.SelectSeat;
import Model.SendOtp;
import Model.SetPassword;
import Model.ShowEditProfile;
import Model.SignupModel;
import Model.StartPoinEndPoint;
import Model.Term;
import Model.Vehical;
import Model.ViewPdf;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("process.php?action=signup")
    Call<SignupModel> signup(
            @Field("first_name") String First_name,
            @Field("last_name") String Last_name,
            @Field("mobile") String Mobile,
            @Field("address") String Address);

    @FormUrlEncoded
    @POST("process.php?action=login")
    Call<LoginModel> login(
            @Field("mobile") String Mobile,
            @Field("password") String Password);

    @FormUrlEncoded
    @POST("process.php?action=set_password")
    Call<SetPassword> setPassword(
            @Field("password") String Password,
            @Field("id") String Id,
            @Field("confirm_password") String ConfirmPassword);

    @FormUrlEncoded
    @POST("process.php?action=send_otp")
    Call<SendOtp> sendOtp(
            @Field("mobile") String Mobile);

    @FormUrlEncoded
    @POST("process.php?action=otp_verify")
    Call<OtpVerify> verify(
            @Field("otp") String Otp);

    @FormUrlEncoded
    @POST("process.php?action=set_new_password")
    Call<NewPassword> newPassword(
            @Field("password") String Password,
            @Field("confirm_password") String Confirm_Password);

    @FormUrlEncoded
    @POST("process.php?action=contact_form")
    Call<ContactUs> contact(
            @Field("user_id") String Id,
            @Field("name") String Name,
            @Field("email") String Email,
            @Field("msg") String Msg);

    @FormUrlEncoded
    @POST("process.php?action=book_ticket")
    Call<BookTicket> bookTicket(
            @Field("user_id") String Id,
            @Field("start_point") String StartPoint,
            @Field("end_point") String EndPoint,
            @Field("journey_date") String JourneyDate,
            @Field("vehicle_type") String Vehicle);

    @GET("process.php?action=vehicle_type")
    Call<List<Vehical>> vehicle();

    @GET("process.php?action=term_condition")
    Call<List<Term>>term_condition();

    @GET("process.php?action=start_end_point")
    Call<List<StartPoinEndPoint>> startEndPoint();

    @FormUrlEncoded
    @POST("process.php?action=offer_img")
    Call<List<OfferImage>> offerImg(
            @Field("user_id") String Id);

    @FormUrlEncoded
    @POST("process.php?action=pickup_location")
    Call<List<PickupLocation>> getPickupLocation(
            @Field("pickup_location") String Pickup,
            @Field("user_id")String UserId,
            @Field("route_date")String RouteDate);

    @FormUrlEncoded
    @POST("process.php?action=drop_location")
    Call<List<DropLocation>> getDropLocation(
            @Field("drop_location") String Drop,
            @Field("user_id")String UserId,
            @Field("route_date")String RouteDate);
    @FormUrlEncoded
    @POST("process.php?action=passenger_detail")
    Call<PassengerDetails> getPassengerData(
            @Field("user_id") String UserId,
            @Field("gender") String Gender,
            @Field("first_name") String FirstName,
            @Field("last_name") String LastName,
            @Field("age")String age,
            @Field("mobile_number") String Mobile,
            @Field("route_id") String RouteId,
            @Field("seat_no") String SeatNo,
            @Field("pickup_id") String PickUpId,
            @Field("drop_id") String DropId);

    @FormUrlEncoded
    @POST("process.php?action=passenger_list")
    Call<List<PassengerList>> getPassengerList(
           @Field("user_id")String UserId,
           @Field("gender") String Gender);


    @FormUrlEncoded
    @POST("process.php?action=search_result")
    Call<List<SearchResult>> getResult(
            @Field("user_id") String Id,
            @Field("start_point") String StartPoint,
            @Field("end_point") String EndPoint,
            @Field("journey_date") String JourneyDate,
            @Field("vehicle_type") String Vehicle,
            @Field("from")String From,
            @Field("to")String To);

    @FormUrlEncoded
    @POST("process.php?action=choose_seat")
    Call<ChooseSeat.SeatData> chooseSeat(
            @Field("id") String Id,
            @Field("user_id") String UserId,
            @Field("from") String From,
            @Field("to")String To,
            @Field("vehicle_type")String Vehicle,
            @Field("route_date")String  RouteDate,
            @Field("single_seat_prize") String  Prize,
            @Field("start_time") String Time,
            @Field("time_duration") String Timeduration,
            @Field("route_distance") String Routedis);


    @FormUrlEncoded
    @POST("process.php?action=select_seat")
    Call<SelectSeat> selectSeat(
            @Field("vehicle_id") String VehicleId,
            @Field("user_id") String UserId,
            @Field("seat_no") String SeatNo);

    @FormUrlEncoded
    @POST("process.php?action=update_profile")
    Call<EditProfile> profile(
            @Field("user_id") String UserId,
            @Field("mobile") String Mobile,
            @Field("address") String Address,
            @Field("first_name") String FirstName,
            @Field("last_name")String LastName);

    @FormUrlEncoded
    @POST("process.php?action=show_update_profile")
    Call<ShowEditProfile> showProfile(
            @Field("user_id") String UserId,
            @Field("mobile") String Mobile,
            @Field("address") String Address,
            @Field("first_name") String FirstName,
            @Field("last_name")String LastName);

    @FormUrlEncoded
    @POST("process.php?action=view_pdf")
    Call<ViewPdf> pdf(
            @Field("booking_id") String Id);

    @FormUrlEncoded
    @POST("process.php?action=add_meal")
    Call<Addmeal> meal(
            @Field("route_id") String Id,
            @Field("meal_category") String Mealcat);

    @FormUrlEncoded
    @POST("process.php?action=home_drop")
    Call<HomeDrop> drop(
            @Field("home_drop_status") String HDS,
            @Field("user_id") String UserId);

    @FormUrlEncoded
    @POST("process.php?action=confirm_details")
    Call<ConfirmDetails> confirmDetails(
            @Field("user_id") String UserId,
            @Field("route_id") String RouteId,
            @Field("passenger_id") String PassengerId,
            @Field("from_to") String FromTo,
            @Field("to_from") String Tofrom,
            @Field("vehicle_type") String Vehicle_type,
            @Field("route_date") String route_date,
            @Field("start_time") String start_time,
            @Field("end_time") String end_time,
            @Field("time_duration") String time_duration,
            @Field("route_distance") String route_distance,
            @Field("meal_id") String meal_id,
            @Field("drop_id") String drop_id);

    @FormUrlEncoded
    @POST("process.php?action=payment_details")
    Call<PaymentDetails> payment(
            @Field("user_id") String user_id,
            @Field("route_id") String route_id);

    @FormUrlEncoded
    @POST("process.php?action=pay_now")
    Call<PayNow> payNow(
            @Field("user_id") String user_id,
            @Field("route_id") String route_id,
            @Field("passenger_id") String PassengerId,
            @Field("ticket_fare") String ticket_fare,
            @Field("meal") String meal,
            @Field("total_amt") String total_amt,
            @Field("transaction_id") String transaction_id,
            @Field("payment_status") String payment_status);

    @FormUrlEncoded
    @POST("process.php?action=seat_available")
    Call<List<SeatAvailable>> seatAvailable(
            @Field("route_id") String RouteId,
            @Field("user_id") String UserId);

    @FormUrlEncoded
    @POST("process.php?action=journey_detail")
    Call<JourneyDetails> journeyDetails(
            @Field("user_id") String UserId,
            @Field("vehicle_id") String VehicleId);


}
