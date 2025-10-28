const express = require('express');
const Razorpay = require('razorpay');
const router = express.Router();

router.post('/create-order', async (req, res) => {
    console.log("Received request to /create-order with body:", req.body);

    const razorpay = new Razorpay({
        key_id: process.env.RAZORPAY_KEY_ID,
        key_secret: process.env.RAZORPAY_KEY_SECRET
    });

    const options = {
        amount: req.body.amount,
        currency: req.body.currency,
        receipt: req.body.receipt,
        notes: req.body.notes
    };

    if (!options.amount || typeof options.amount !== 'number' || options.amount <= 0) {
        console.error("Validation Error: Invalid 'amount' received:", options.amount);
        return res.status(400).send("Invalid amount provided.");
    }

    try {
        const order = await razorpay.orders.create(options);
        console.log("Razorpay order created successfully:", order);
        res.json(order);
    } catch (error) {
        console.error("Error creating Razorpay order:", error);
        res.status(500).send("Error creating Razorpay order");
    }
});

module.exports = router;