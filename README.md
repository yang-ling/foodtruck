# Food Truck API

This API can list and filter Food Truck related items.

## Quick start

### Docker Compose

``` sh
./up.sh
```

Then visit http://localhost:8081/api/v1/list

## API Endpoits

``` sh
http://<server>:8081/api/v1/list?applicant=xxx&facilityType=xxx&locationDescription=xxx&address=xxx&status=xxx&foodItems=xxx
```

All query parameters are optional. If no query parameters are given, all data are returned.

### Example Query

http://localhost:8081/api/v1/list?foodItems=Cream&facilityType=Truck
