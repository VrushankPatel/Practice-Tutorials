const express = require("express");
const app = express();

const port = process.env.PORT;

// in this program, we'll take port from env variable, and run this server on that port.
// For windows, run this program as >> set PORT=3000 && node server.js
// for linux, run as >> PORT=3000 node server.js
// server will run on specified port, for this example, we've to run this server in multiple cmds or terminals on multiple ports.
// we'll distribute the load among all the replications of this server in different ports.
// Use 3000, 3001 and so on because that is the port sequence we're going to use in nginx.
app.listen(port, () => console.log(`Listening on port ${port}.`));

app.get("/hello", (req, res) => {
	console.log(req.headers);
	res.send(`Hello from port ${port}.\n`);
});
