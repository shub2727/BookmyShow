package com.example.BookMyShow_Booking.Conroller;


import com.example.BookMyShow_Booking.ApiConstant.Constants;
import com.example.BookMyShow_Booking.Dto.BookingDto;
import com.example.BookMyShow_Booking.Service.BookingService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/booking")
public class BookingController {


    @Autowired
    BookingService bookingService;

    @PostMapping("/")
    public ResponseEntity<Constants> creeateBooking(@RequestBody BookingDto bookingDto) {
        Constants constants = new Constants();

        BookingDto booking = bookingService.createBooking(bookingDto);
        constants.setBookingId(booking.getBookingId());
        constants.setUserID(booking.getUserId());
        constants.setName(booking.getUser().getName());
        constants.setUserName(booking.getUser().getUserName());
        constants.setEmail(booking.getUser().getEmail());

        constants.setTotalAmount(booking.getTotalAmount());
        constants.setStatus(booking.getStatus());
        constants.setSeats(booking.getSeats());

        constants.setMovieId(booking.getMovieId());
        constants.setMovieName(booking.getMovies().getName());
        constants.setCategory(booking.getMovies().getCategory());
        constants.setGenre(booking.getMovies().getGenre());
        constants.setRating(booking.getMovies().getRating());
        constants.setLanguage(booking.getMovies().getLanguage());
        constants.setPoster(booking.getMovies().getPoster());

        constants.setShowtimeID(bookingDto.getShowTimeId());
        constants.setTheaterId(booking.getTheaterId());
        constants.setTheatername(booking.getTheaters().getName());
        constants.setLocation(booking.getTheaters().getLocation());
        constants.setScreens(booking.getTheaters().getScreens());
        constants.setFoodName(booking.getFoodName());

        constants.setPaymentID(booking.getPaymentID());
        constants.setPaymentStatus("Conformed");
        constants.setTotaPayedAmountt(booking.getTotalAmount());
        constants.setCardNumber(booking.getCardNumber());
        constants.setCardHolderName(booking.getCardHolderName());
        constants.setCardExpire(booking.getCardExpire());
        constants.setCardCvv(booking.getCardCvv());
        constants.setTimestamp(booking.getTimestamp());


        return new ResponseEntity<>(constants, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<Constants>> getAllmovies() {

        List<BookingDto> bookingDto = bookingService.getAll();

        List<Constants> constantss = new ArrayList<>();

        bookingDto.stream().map((booking) -> {


            Constants constants = new Constants();
            constants.setBookingId(booking.getBookingId());
            constants.setUserID(booking.getUserId());
            constants.setName(booking.getUser().getName());
            constants.setUserName(booking.getUser().getUserName());
            constants.setEmail(booking.getUser().getEmail());

            constants.setTotalAmount(booking.getTotalAmount());
            constants.setStatus(booking.getStatus());
            constants.setSeats(booking.getSeats());

            constants.setMovieId(booking.getMovieId());
            constants.setMovieName(booking.getMovies().getName());
            constants.setCategory(booking.getMovies().getCategory());
            constants.setGenre(booking.getMovies().getGenre());
            constants.setRating(booking.getMovies().getRating());
            constants.setLanguage(booking.getMovies().getLanguage());
            constants.setPoster(booking.getMovies().getPoster());

            constants.setShowtimeID(booking.getShowTimeId());
            constants.setTheaterId(booking.getTheaterId());
            constants.setTheatername(booking.getTheaters().getName());
            constants.setLocation(booking.getTheaters().getLocation());
            constants.setScreens(booking.getTheaters().getScreens());

            constants.setFoodName(booking.getFoodName());


            constants.setPaymentID(booking.getPaymentID());
            constants.setPaymentStatus("Conformed");
            constants.setTotaPayedAmountt(booking.getTotalAmount());
            constants.setCardNumber(booking.getCardNumber());
            constants.setCardHolderName(booking.getCardHolderName());
            constants.setCardExpire(booking.getCardExpire());
            constants.setCardCvv(booking.getCardCvv());
            constants.setTimestamp(booking.getTimestamp());

            constantss.add(constants);
            return booking;

        }).collect(Collectors.toList());


        return new ResponseEntity<>(constantss, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Constants> getBookingByID(@PathVariable String id) {

        BookingDto booking = bookingService.getById(id);

        Constants constants = new Constants();
        constants.setBookingId(booking.getBookingId());
        constants.setUserID(booking.getUserId());
        constants.setName(booking.getUser().getName());
        constants.setUserName(booking.getUser().getUserName());
        constants.setEmail(booking.getUser().getEmail());

        constants.setTotalAmount(booking.getTotalAmount());
        constants.setStatus(booking.getStatus());
        constants.setSeats(booking.getSeats());

        constants.setMovieId(booking.getMovieId());
        constants.setMovieName(booking.getMovies().getName());
        constants.setCategory(booking.getMovies().getCategory());
        constants.setGenre(booking.getMovies().getGenre());
        constants.setRating(booking.getMovies().getRating());
        constants.setLanguage(booking.getMovies().getLanguage());
        constants.setPoster(booking.getMovies().getPoster());

        constants.setShowtimeID(booking.getShowTimeId());
        constants.setTheaterId(booking.getTheaterId());
        constants.setTheatername(booking.getTheaters().getName());
        constants.setLocation(booking.getTheaters().getLocation());
        constants.setScreens(booking.getTheaters().getScreens());
        constants.setFoodName(booking.getFoodName());


        constants.setPaymentID(booking.getPaymentID());
        constants.setPaymentStatus("Conformed");
        constants.setTotaPayedAmountt(booking.getTotalAmount());
        constants.setCardNumber(booking.getCardNumber());
        constants.setCardHolderName(booking.getCardHolderName());
        constants.setCardExpire(booking.getCardExpire());
        constants.setCardCvv(booking.getCardCvv());
        constants.setTimestamp(booking.getTimestamp());

        return new ResponseEntity<>(constants, HttpStatus.CREATED);
    }

    @GetMapping("/byUserId/{userId}")
    public ResponseEntity<List<Constants>> BookingByUserId(@PathVariable String userId){

        List<BookingDto> bookingDto= bookingService.getByUserId(userId);
        List<Constants> constantsList= new ArrayList<>();



        bookingDto.stream().forEach((booking)->{
            Constants constants = new Constants();
            constants.setBookingId(booking.getBookingId());
            constants.setUserID(booking.getUserId());
            constants.setName(booking.getUser().getName());
            constants.setUserName(booking.getUser().getUserName());
            constants.setEmail(booking.getUser().getEmail());

            constants.setTotalAmount(booking.getTotalAmount());
            constants.setStatus(booking.getStatus());
            constants.setSeats(booking.getSeats());

            constants.setMovieId(booking.getMovieId());
            constants.setMovieName(booking.getMovies().getName());
            constants.setCategory(booking.getMovies().getCategory());
            constants.setGenre(booking.getMovies().getGenre());
            constants.setRating(booking.getMovies().getRating());
            constants.setLanguage(booking.getMovies().getLanguage());
            constants.setPoster(booking.getMovies().getPoster());

            constants.setShowtimeID(booking.getShowTimeId());
            constants.setTheaterId(booking.getTheaterId());
            constants.setTheatername(booking.getTheaters().getName());
            constants.setLocation(booking.getTheaters().getLocation());
            constants.setScreens(booking.getTheaters().getScreens());

            constants.setFoodName(booking.getFoodName());


            constants.setPaymentID(booking.getPaymentID());
            constants.setPaymentStatus("Conformed");
            constants.setTotaPayedAmountt(booking.getTotalAmount());
            constants.setCardNumber(booking.getCardNumber());
            constants.setCardHolderName(booking.getCardHolderName());
            constants.setCardExpire(booking.getCardExpire());
            constants.setCardCvv(booking.getCardCvv());
            constants.setTimestamp(booking.getTimestamp());

            constantsList.add(constants);
        });


        return new ResponseEntity<>(constantsList,HttpStatus.CREATED);
    }

    @GetMapping("/downloadExcel")
    public void generateExcel(HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";

        String headerValue = "attachment;filename= data.xls";

        response.setHeader(headerKey, headerValue);

        this.bookingService.generateExcel(response);
    }


    @GetMapping("/downloadPdf/{bookingId}")
    public void generatePdf(HttpServletResponse response,@PathVariable String bookingId) throws Exception {

        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        bookingService.generatePdf(response,bookingId);

        // UserPDFExporter exporter = new UserPDFExporter(listUsers);

        // exporter.export(response);

    }

}
