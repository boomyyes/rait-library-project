require('dotenv').config();
const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const authRoutes = require('./routes/auth');

const app = express();
const PORT = process.env.PORT || 3001;
const DB_URI = 'mongodb://localhost:27017/authdb';

// Middleware
app.use(cors());
app.use(express.json());

// Routes
app.use('/api/auth', authRoutes);

// Connect to DB and Start Server
console.log('Attempting to connect to MongoDB...');
mongoose.connect(DB_URI)
  .then(() => {
    console.log('MongoDB connected successfully to authdb.');
    app.listen(PORT, () => {
      console.log(`Auth service running on port ${PORT}`);
    });
  })
  .catch(err => {
    console.error('!!! Could not connect to MongoDB !!!');
    console.error(err);
    process.exit(1);
  });
