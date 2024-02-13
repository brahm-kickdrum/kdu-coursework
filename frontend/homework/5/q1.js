const os = require('os');
const fs = require('fs');
const http = require('http');

// Function to get system information and return as JSON
function getSystemInfo() {
    return {
        HostName: os.hostname(),
        OperatingSystem: os.platform(),
        Architecture: os.arch(),
        OSRelease: os.release(),
        Uptime: os.uptime(),
        NumberOfCPUCores: os.cpus().length,
        TotalMemory: os.totalmem(),
        FreeMemory: os.freemem(),
        CurrentWorkingDirectory: process.cwd()
    };
}

// Writing system information JSON to a local file
function writeSystemInfoToFile() {
    const systemInfo = getSystemInfo();
    fs.writeFileSync('systemInfo.json', JSON.stringify(systemInfo, null, 2));
}

// Function to create a simple HTTP server
function createServer() {
    const server = http.createServer((req, res) => {
        // Read the previously created JSON file
        fs.readFile('systemInfo.json', 'utf8', (err, data) => {
            if (err) {
                res.writeHead(500, { 'Content-Type': 'text/plain' });
                res.end('Internal Server Error');
                return;
            }

            res.writeHead(200, { 'Content-Type': 'application/json' });
            res.end(data);
        });
    });

    const PORT = process.env.PORT || 3000;
    server.listen(PORT, () => {
        console.log(`Server running on port ${PORT}`);
    });
}

// Call the functions to write to file and create server
writeSystemInfoToFile();
createServer();
