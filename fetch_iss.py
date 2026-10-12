#!/usr/bin/python

import urllib2
import json
import time
import sys

API_URL = "http://api.open-notify.org/iss-now.json"

while True:
    try:
        response = urllib2.urlopen(API_URL, timeout=10)
        data = response.read()

        # Print one API response as one Flume event
        print(data)
        sys.stdout.flush()

        # Open Notify recommends polling around every 5 seconds
        time.sleep(5)

    except Exception as e:
        sys.stderr.write("Error: %s\n" % str(e))
        sys.stderr.flush()
        time.sleep(5)