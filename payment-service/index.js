require('dotenv').config();
const express = require('express');
const cors = require('cors');
const paymentRoutes = require('./routes/payment');

const app = express();
const PORT = process.env.PORT || 3002;

app.use(cors());
app.use(express.json());

app.use('/api/payments', paymentRoutes);

app.listen(PORT, () => {
  console.log(`Payment service running on port ${PORT}`);
});
