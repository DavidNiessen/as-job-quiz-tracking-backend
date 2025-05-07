# Tracking Backend

Simple anonymous tracking for Axel Springer Job Quiz

## Routes

**GET /api/tracking**<br>
example response:

```
[
  {
    eventName: PAGE_LOAD
    count: 1
  }
]
```

**GET /api/tracking?eventName=EVENT_NAME**<br>
example response:

```
{
  eventName: EVENT_NAME
  count: 1
}
```

**POST /api/tracking**<br>
example request body:

```
{
  eventName: PAGE_LOAD
}
```
