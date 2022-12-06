package food.infra;

import food.domain.*;
import food.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MypageViewHandler {

    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setStatus("미결재");
            mypage.setOrderId(String.valueOf(orderPlaced.getId()));
            // view 레파지 토리에 save
            mypageRepository.save(mypage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
                // view 객체 조회

                List<Mypage> mypageList = mypageRepository.findByOrderId(paid.getOrderId());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus("결재됨");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccepted_then_UPDATE_2(@Payload OrderAccepted orderAccepted) {
        try {
            if (!orderAccepted.validate()) return;
                // view 객체 조회

                List<Mypage> mypageList = mypageRepository.findByOrderId(orderAccepted.getOrderId());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus("접수됨");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderRejected_then_UPDATE_3(@Payload OrderRejected orderRejected) {
        try {
            if (!orderRejected.validate()) return;
                // view 객체 조회

                List<Mypage> mypageList = mypageRepository.findByOrderId(orderRejected.getOrderId());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus("거부됨");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_4(@Payload CookStarted cookStarted) {
        try {
            if (!cookStarted.validate()) return;
                // view 객체 조회

                List<Mypage> mypageList = mypageRepository.findByOrderId(cookStarted.getOrderId());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus("요리시작");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_5(@Payload CookFinished cookFinished) {
        try {
            if (!cookFinished.validate()) return;
                // view 객체 조회

                List<Mypage> mypageList = mypageRepository.findByOrderId(cookFinished.getOrderId());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus("요리완료");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPicked_then_UPDATE_6(@Payload Picked picked) {
        try {
            if (!picked.validate()) return;
                // view 객체 조회

                List<Mypage> mypageList = mypageRepository.findByOrderId(picked.getOrderId());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus("배송시작");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_7(@Payload Delivered delivered) {
        try {
            if (!delivered.validate()) return;
                // view 객체 조회

                List<Mypage> mypageList = mypageRepository.findByOrderId(delivered.getOrderId());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus("배송확정");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_DELETE_1(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            mypageRepository.deleteById(orderCanceled.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

