#!/bin/bash
set -e

# run build
npm run build

# run unit test
npm run test -- --watch=false --no-progress --browsers=ChromeHeadlessCI

# TODO: run e2e test
