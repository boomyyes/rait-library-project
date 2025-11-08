require('dotenv').config();
const express = require('express');
const cors = require('cors');
const paymentRoutes = require('./routes/payment');

const app = express();
const PORT = process.env.PORT || 3002;

// CORS configuration for production (no protection for now since it allows every link whatsoever)
const corsOptions = {
  origin: ['http://localhost:3000', 'https://rait-library-project.vercel.app', 'https://*.vercel.app'],
  credentials: true 
};
app.use(cors(corsOptions));

app.use(express.json());

// Health check route (required for deployment)
app.get('/health', (req, res) => {
  res.status(200).json({ 
    status: 'OK', 
    service: 'payment-service',
    timestamp: new Date().toISOString()
  });
});

// Routes
app.use('/api/payments', paymentRoutes);

app.listen(PORT, () => {
  console.log(`Payment service running on port ${PORT}`);
  console.log(`Health check: http://localhost:${PORT}/health`);
});