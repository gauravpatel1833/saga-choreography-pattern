# saga-choreography-pattern
Project for implementing saga choreography pattern of microservices using spring kafka binder.

![image](https://user-images.githubusercontent.com/8069743/132987565-cecf9925-de10-4440-8156-51942c6ef397.png)

Order Service will send order
Post:- http://localhost:8081/order/create
Request:
{
    "userId": 101,
    "productId": 4373,
    "amount": 100
}

It get stored in PURCHASE_ORDER_TBL table and send message to order-event kafka topic. Then payment service will check user balance if it is having enough balance then payment will be success and order get completed by sending message to kafka topic payment-event.

If user don’t have enough balance, then payment will be failed. And order service will send order cancel to topic.

Learnt From : https://www.youtube.com/watch?v=6O5iJ7PKUhs&t=2s

![image](https://user-images.githubusercontent.com/8069743/132987669-686f40bd-c0e9-430c-9908-3dc469e398f8.png)


