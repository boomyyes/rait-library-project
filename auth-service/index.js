require('dotenv').config();
const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const authRoutes = require('./routes/auth');

const app = express();
const PORT = process.env.PORT || 3001;

// Use environment variable for MongoDB
const DB_URI = process.env.MONGODB_URI || 'mongodb://localhost:27017/authdb';

// CORS configuration for production (no protection for now because it allows every link)
const corsOptions = {
  origin: [
    'http://localhost:3000', 
    /^https:\/\/rait-library-project.*\.vercel\.app$/
  ],
  credentials: true
};

app.use(cors(corsOptions));

app.use(express.json());

// Health check route (required for deployment)
app.get('/health', (req, res) => {
  res.status(200).json({ 
    status: 'OK', 
    service: 'auth-service',
    timestamp: new Date().toISOString()
  });
});

// Routes
app.use('/api/auth', authRoutes);

// Connect to DB and Start Server
console.log('Attempting to connect to MongoDB...');
console.log('Database:', DB_URI);

mongoose.connect(DB_URI)
  .then(() => {
    console.log('MongoDB connected successfully to authdb.');
    app.listen(PORT, () => {
      console.log(`Auth service running on port ${PORT}`);
      console.log(`Health check: http://localhost:${PORT}/health`);
    });
  })
  .catch(err => {
    console.error('!!! Could not connect to MongoDB !!!');
    console.error('Error:', err.message);
    process.exit(1);
  });