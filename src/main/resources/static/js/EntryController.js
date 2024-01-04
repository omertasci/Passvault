//var entryController = EntryController();

var baseurl = '/passvault/';

class EntryController {

constructor() {}

  getEntryById(id, success, error) {
    $.ajax({
      url: baseurl + "entry/" +id,
      type: "GET",
      dataType: "json",
      success: success,
      error: error,
    });
  }

  saveEntry(data, success, error) {
    $.ajax({
      url: baseurl + "entry",
      type: "POST",
      dataType: "json",
      contentType: 'application/json; charset=utf-8',
      data: JSON.stringify(data),
      success: success,
      error: error,
    });
  }

  updateEntryById(id, success, error) {
    $.ajax({
      url: baseurl + "entry/" +id,
      type: "PUT",
      dataType: "json",
      success: success,
      error: error,
    });
  }

  deleteEntryById(id, success, error) {
    $.ajax({
      url: baseurl + "entry/" +id,
      type: "DELETE",
      dataType: "json",
      success: success,
      error: error,
    });
  }
}
