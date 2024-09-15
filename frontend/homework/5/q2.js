const path = require('path');

// Function to extract file information from a file path
function extractFileInfo(filePath) {
    return {
        extension: path.extname(filePath),
        baseName: path.basename(filePath),
        directory: path.dirname(filePath)
    };
}

// Function to process an array of file paths and return an array of objects with file information
function processFilePaths(filePaths) {
    return filePaths.map(filePath => extractFileInfo(filePath));
}

// Example file paths
const filePaths = [
    'dir1/dir2/file1.txt',
    'dir1/dir3/file2.txt',
    'dir1/dir3/file3.md',
    'dir4/file4.jpg',
    'dir4/file5.pdf'
];

// Output the result of processing file paths
console.log(processFilePaths(filePaths));
